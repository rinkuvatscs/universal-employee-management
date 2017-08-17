package com.universal.employee.service;

import com.universal.employee.model.Company;

public interface CompanyService {

 public Company createCompany(Company company);
    
    public Company findCompany(Integer companyId) ;
}
