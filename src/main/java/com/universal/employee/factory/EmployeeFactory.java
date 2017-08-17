package com.universal.employee.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.universal.employee.dao.EmployeeDao;

@Component
public class EmployeeFactory {

    @Value("${universal.employee.management.data.store.mode}")
    String mode;

    @Autowired
    List<EmployeeDao> employeeDaoList;

    public EmployeeDao getEmployeeDao() {

        return getEmployeeDao(mode);
    }

    public EmployeeDao getEmployeeDao(String applicationMode) {

        for (EmployeeDao employeeDao : employeeDaoList) {
            if (employeeDao.getApplicationModeType().name().equals(applicationMode)) {
                return employeeDao;
            }
        }
        return null;
    }
}
