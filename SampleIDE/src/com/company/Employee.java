package com.company;

public class Employee {

    // properties or data
    private long empId;
    private int age;
    private String name;
    private String dept;

    // define constructor - tells how to create object
    public Employee(long empId, int age, String name, String dept) {
        this.empId = empId;
        this.age = age;
        this.name = name;
        this.dept = dept;
    }

    public Employee(long empId) {
        this.empId = empId;
    }

    //overloaded constructor
    public Employee(long empId, int age) {
        this.empId = empId;
        this.age = age;
    }


    // Getters
    public long getEmpId() {
        return empId;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setDept(String dept, int age) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "This is employee "+ this.name;
    }

    // behaviours
    public void writeCode() {
        System.out.println("I can write java code");
    }
}
