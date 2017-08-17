package com.universal.employee.constant;

public enum UniversalEmployeeType {

    WELCOME_NOTE("Welcome to Universal Employee Management");
    
    private String note;

    UniversalEmployeeType(String note) {
        this.note = note;
    }

    public final String getNote() {

        return note;
    }

}
