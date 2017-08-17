package com.universal.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal.employee.factory.EmployeeFactory;
import com.universal.employee.model.Employee;
import com.universal.employee.request.EmployeeRequest;
import com.universal.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeFactory employeeFactory;

    @Override
    public Employee createEmployee(Integer companyId, EmployeeRequest employeeRequest) {

        return employeeFactory.getEmployeeDao().createEmployee(companyId, employeeRequest);
    }

    @Override
    public Employee deleteEmployee(Integer companyId, Integer employeeId) {

        return employeeFactory.getEmployeeDao().deleteEmployee(companyId, employeeId);
    }

    @Override
    public Employee updateEmployee(Integer companyId, EmployeeRequest employee) {

        return employeeFactory.getEmployeeDao().updateEmployee(companyId, employee);
    }

    @Override
    public Employee findEmployee(Integer companyId, Integer employeeId) {

        return employeeFactory.getEmployeeDao().findEmployee(companyId, employeeId);
    }

}
