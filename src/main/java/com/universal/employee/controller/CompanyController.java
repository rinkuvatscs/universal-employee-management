package com.universal.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.universal.employee.model.Company;
import com.universal.employee.service.CompanyService;

@RestController
@RequestMapping("/universal/company")
public class CompanyController {

    @Autowired
    private CompanyService companyServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Company createCompany(@RequestBody Company company) {

        return companyServiceImpl.createCompany(company);
    }

}
