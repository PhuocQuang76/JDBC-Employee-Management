package com.example;

import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeException;
import com.example.dao.EmployeeFactory;
import com.example.pojos.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeDao dao = EmployeeFactory.get();
        Employee emp = new Employee( 6,"Alex", 3412.32, 103, 2);


        System.out.println("\nAdd employee into database: ");
        try {
            String s = dao.register(emp);
            System.out.println(s);
        } catch (EmployeeException e) {
            e.printStackTrace();
        }

        System.out.println("List All employee inn the database: ");
        List<Employee> eList;
        try {
            eList = dao.findAll();
            eList.forEach(e -> System.out.println(e));
        } catch (EmployeeException e) {
            System.out.println(e);
        }


        System.out.println("\nFind one employee with special Id: ");
        try {
            Employee employee = dao.findById(2);
            System.out.println(employee);
        } catch (EmployeeException e) {
            e.printStackTrace();
        }


        System.out.println("\nDelete a record: ");
        try {
            int n = dao.remove(1);
            System.out.println(n + " record was deleted. ");
        } catch (EmployeeException e) {
            e.printStackTrace();
        }

        System.out.println("\nUpdate an employee record:");
        Employee updateEmp = new Employee(3,"Tony",4300.61,103,4);
        try {
            String message = dao.update(updateEmp);
            System.out.println(message);
        } catch (EmployeeException e) {
            e.printStackTrace();
        }


//        String jdbcURL="jdbc:mysql://localhost:3306/javaoursoul2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//        //Class.forName("com.mysql.cj.jdbc.Driver");
//        List<Employee> empList=new ArrayList<>();
//
//        try {
//            Connection con= DriverManager.getConnection(jdbcURL,"root","NHOel@2804");
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery("select * from employee");
//            while(rs.next()) {
//                int id=rs.getInt(1);
//                String name=rs.getString("name");
//                double salary=rs.getDouble("salary");
//                int did=rs.getInt("DEPT_ID");
//                int mgr_id= rs.getInt("MGR_ID");
//                empList.add(new Employee(id,name,salary,did,mgr_id));
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//            //e.printStackTrace();
//        }
//
//        empList.forEach(e->System.out.println(e));
    }

}
