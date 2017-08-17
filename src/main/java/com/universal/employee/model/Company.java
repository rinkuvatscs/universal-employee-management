package com.universal.employee.model;


public class Company  extends CompanyIdentity {

    private String companyName ;
    private String companyAddress;
    private String registrationNumber ;
    private EmployeType employeType ;
    

    
    public final String getCompanyName() {
    
        return companyName;
    }
    
    public final void setCompanyName(String companyName) {
    
        this.companyName = companyName;
    }
    
    public final String getCompanyAddress() {
    
        return companyAddress;
    }
    
    public final void setCompanyAddress(String companyAddress) {
    
        this.companyAddress = companyAddress;
    }
    
    public final String getRegistrationNumber() {
    
        return registrationNumber;
    }
    
    public final void setRegistrationNumber(String registrationNumber) {
    
        this.registrationNumber = registrationNumber;
    }
    
    
    public final EmployeType getEmployeType() {
    
        return employeType;
    }

    
    public final void setEmployeType(EmployeType employeType) {
    
        this.employeType = employeType;
    }

    @Override
    public String toString() {

        return "Company [companyName=" + companyName + ", companyAddress=" + companyAddress + ", registrationNumber="
                + registrationNumber + ", employeType=" + employeType + "]";
    }


}
