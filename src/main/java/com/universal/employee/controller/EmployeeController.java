package com.universal.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.universal.employee.model.Employee;
import com.universal.employee.request.EmployeeRequest;
import com.universal.employee.service.EmployeeService;

@RestController
@RequestMapping("/universal/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServiceImpl;

	@RequestMapping(value = "/{companyId}", method = RequestMethod.POST)
	@ResponseBody
	public Employee createEmployee(@PathVariable Integer companyId,
			@RequestBody EmployeeRequest employeeRequest) {

		return employeeServiceImpl.createEmployee(companyId, employeeRequest);
	}

	@RequestMapping(value = "/{companyId}/{employeeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Employee deleteEmployee(@PathVariable Integer companyId,
			@PathVariable Integer employeeId) {

		return employeeServiceImpl.deleteEmployee(companyId, employeeId);
	}

	@RequestMapping(value = "/{companyId}", method = RequestMethod.PUT)
	@ResponseBody
	public Employee updateEmployee(@PathVariable Integer companyId,
			@RequestBody EmployeeRequest employeeRequest) {

		return employeeServiceImpl.updateEmployee(companyId, employeeRequest);
	}

	@RequestMapping(value = "/{companyId}/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public Employee findEmployee(@PathVariable Integer companyId,
			@PathVariable Integer employeeId) {

		return employeeServiceImpl.findEmployee(companyId, employeeId);
	}

}
