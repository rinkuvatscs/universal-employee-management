package com.universal.employee.model;


public class CompanyIdentity {

    private Integer companyId ;

    
    public final Integer getCompanyId() {
    
        return companyId;
    }

    
    public final void setCompanyId(Integer companyId) {
    
        this.companyId = companyId;
    }


    @Override
    public String toString() {

        return "CompanyIdentity [companyId=" + companyId + "]";
    }
    
    
    
}
