package com.universal.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal.employee.dao.impl.CompanyCacheDaoImpl;
import com.universal.employee.model.Company;
import com.universal.employee.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyCacheDaoImpl companyCacheDaoImpl;

    @Override
    public Company createCompany(Company company) {

        return companyCacheDaoImpl.createCompany(company);
    }

    @Override
    public Company findCompany(Integer companyId) {

        throw new UnsupportedOperationException("Unsupported method");
    }

}
