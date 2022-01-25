package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Today = " + new Date());

        Employee employee1 = new Employee(101, 39, "Nila", "Eng");
        System.out.println(employee1.getName());
        System.out.println(employee1.getDept());

        // modifying data using setters
        employee1.setDept("New Dept");
        System.out.println(employee1.getDept());
        System.out.println(employee1.toString());
    }


}
