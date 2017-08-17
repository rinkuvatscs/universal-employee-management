package com.universal.employee.dao;

import com.universal.employee.model.ApplicationModeType;
import com.universal.employee.model.Employee;
import com.universal.employee.request.EmployeeRequest;

public interface EmployeeDao {

    public Employee createEmployee(Integer companyId, EmployeeRequest employee);

    public Employee deleteEmployee(Integer companyId, Integer employeeId);

    public Employee updateEmployee(Integer companyId, EmployeeRequest employee);

    public Employee findEmployee(Integer companyId, Integer employeeId);
    
    public ApplicationModeType getApplicationModeType() ;

}
