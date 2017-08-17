package com.universal.employee.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.universal.employee.dao.EmployeeDao;
import com.universal.employee.exception.CustomException;
import com.universal.employee.model.ApplicationModeType;
import com.universal.employee.model.Employee;
import com.universal.employee.request.EmployeeRequest;

@Repository
public class EmployeeCacheDaoImpl implements EmployeeDao {

    static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCacheDaoImpl.class);

    private static final Map<Integer, Employee> employeeData = new ConcurrentHashMap<>();

    @Autowired
    private CompanyCacheDaoImpl companyCacheDaoImpl;

    @Override
    public Employee createEmployee(Integer companyId, EmployeeRequest employeeRequest) {

        if (!employeeData.containsKey(employeeRequest.getEmployeeId())
                && !StringUtils.isEmpty(companyCacheDaoImpl.findCompany(companyId))) {
            Employee employee = new Employee();
            try {
                BeanUtils.copyProperties(employee, employeeRequest);
            } catch (IllegalAccessException | InvocationTargetException e) {
                LOGGER.error("Can not add Employee with {} due to {}", employeeRequest, e);
                throw new CustomException("Can not add Employee with {" + employeeRequest + "} due to {" + e + "}");
            }
            employee.setCompanyId(companyId);
            employeeData.put(employee.getEmployeeId(), employee);
            return employee;
        }

        return null;
    }

    @Override
    public Employee deleteEmployee(Integer companyId, Integer employeeId) {

        return findEmployee(companyId, employeeId);
    }

    @Override
    public Employee updateEmployee(Integer companyId, EmployeeRequest employeeRequest) {

        Employee employee = findEmployee(companyId, employeeRequest.getEmployeeId());
        if (!StringUtils.isEmpty(employee)) {
            try {
                copyPropertiesIgnoreNull(employeeRequest, employee);
                employeeData.put(employee.getEmployeeId(), employee);
                return employee;
            } catch (IllegalAccessException | InvocationTargetException e) {
                LOGGER.error("Can not update Employee with {} due to {}", employeeRequest, e);
                throw new CustomException("Can not update Employee with {" + employeeRequest + "} due to {" + e + "}");
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(Integer companyId, Integer employeeId) {

        Employee employee = employeeData.get(employeeId);
        if (!StringUtils.isEmpty(employee) && employee.getCompanyId() == companyId) {
            return employee;
        }
        return null;
    }

    @Override
    public ApplicationModeType getApplicationModeType() {

        return ApplicationModeType.CACHE;
    }

    public void copyPropertiesIgnoreNull(Object source, Object dest)
            throws IllegalAccessException, InvocationTargetException {

        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        for (java.beans.PropertyDescriptor pd : pds) {
            if (!src.isReadableProperty(pd.getName()) || pd.getWriteMethod() == null) {
                continue;
            }
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                continue;
            }
            BeanUtils.copyProperty(dest, pd.getName(), srcValue);
        }
    }
}
