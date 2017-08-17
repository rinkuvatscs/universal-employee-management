package com.universal.employee.dao;

import com.universal.employee.model.ApplicationModeType;
import com.universal.employee.model.Company;

public interface CompanyDao {

    public Company createCompany(Company company);
    
    public Company findCompany(Integer companyId) ;
    
    public ApplicationModeType getApplicationModeType() ;
}
