package com.example.pojos;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int deptId;
    private int manager_id;
    public Employee() {

    }

    public Employee(String name, double salary, int deptId, int manager_id) {
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
        this.manager_id = manager_id;
    }

    public Employee(int id, String name, double salary, int deptId, int manager_id) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
        this.manager_id = manager_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getDeptId() {
        return deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", deptId=" + deptId +
                ", manager_id=" + manager_id +
                '}';
    }
}
