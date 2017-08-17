package com.universal.employee.dao.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.universal.employee.dao.CompanyDao;
import com.universal.employee.model.ApplicationModeType;
import com.universal.employee.model.Company;

@Repository
public class CompanyCacheDaoImpl implements CompanyDao {

    private static final Map<Integer, Company> companyData = new ConcurrentHashMap<>();

    @Override
    public Company createCompany(Company company) {

        if (!companyData.containsKey(company.getCompanyId())) {

            companyData.put(company.getCompanyId(), company);
            return company;
        }
        return null;
    }

    @Override
    public ApplicationModeType getApplicationModeType() {

        return ApplicationModeType.CACHE;
    }

    @Override
    public Company findCompany(Integer companyId) {

        return companyData.get(companyId);
    }

}
