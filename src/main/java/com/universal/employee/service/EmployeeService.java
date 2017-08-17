package com.universal.employee.service;

import com.universal.employee.model.Employee;
import com.universal.employee.request.EmployeeRequest;

public interface EmployeeService {

    public Employee createEmployee(Integer companyId, EmployeeRequest employee);

    public Employee deleteEmployee(Integer companyId, Integer employeeId);

    public Employee updateEmployee(Integer companyId, EmployeeRequest employee);

    public Employee findEmployee(Integer companyId, Integer employeeId);

}
