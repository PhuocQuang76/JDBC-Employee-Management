package com.example.dao;

public class EmployeeFactory {
    public static EmployeeDao get() {
        return new EmployeeDaoImpl();
    }
}
