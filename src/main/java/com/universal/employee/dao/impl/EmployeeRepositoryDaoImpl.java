package com.universal.employee.dao.impl;

import org.springframework.stereotype.Repository;

import com.universal.employee.dao.EmployeeDao;
import com.universal.employee.model.ApplicationModeType;
import com.universal.employee.model.Employee;
import com.universal.employee.request.EmployeeRequest;

@Repository
public class EmployeeRepositoryDaoImpl implements EmployeeDao {

    @Override
    public Employee createEmployee(Integer companyId, EmployeeRequest employee) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee deleteEmployee(Integer companyId, Integer employeeId) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee updateEmployee(Integer companyId, EmployeeRequest employee) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee findEmployee(Integer companyId, Integer employeeId) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApplicationModeType getApplicationModeType() {

        return ApplicationModeType.MYSQL;
    }

}
