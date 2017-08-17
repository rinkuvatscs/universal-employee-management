package com.universal.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universal.employee.constant.UniversalEmployeeType;

@RestController
public class UniversalEmployeeController {

    
    @RequestMapping("/")
    public String welcomeNote() {

        return UniversalEmployeeType.WELCOME_NOTE.getNote();
    }
}
