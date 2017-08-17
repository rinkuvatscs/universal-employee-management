package com.universal.employee.request;


public class EmployeeRequest {

    private int employeeId;
    private String employeeName;
    private String designation;
    private String aadhaar;

    public final int getEmployeeId() {

        return employeeId;
    }

    public final void setEmployeeId(int employeeId) {

        this.employeeId = employeeId;
    }

    public final String getEmployeeName() {

        return employeeName;
    }

    public final void setEmployeeName(String employeeName) {

        this.employeeName = employeeName;
    }

    public final String getDesignation() {

        return designation;
    }

    public final void setDesignation(String designation) {

        this.designation = designation;
    }

    public final String getAadhaar() {

        return aadhaar;
    }

    public final void setAadhaar(String aadhaar) {

        this.aadhaar = aadhaar;
    }

    @Override
    public String toString() {

        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", designation=" + designation
                + ", aadhaar=" + aadhaar + "]";
    }
}
