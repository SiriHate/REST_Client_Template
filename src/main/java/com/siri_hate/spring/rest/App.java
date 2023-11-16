package com.siri_hate.spring.rest;

import com.siri_hate.spring.rest.configuration.MyConfig;
import com.siri_hate.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        // Get all employees
        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        // Get employee with an id = 1
        Employee employee1 = communication.getEmployee(1);
        System.out.println(employee1);

        // Update or create new employee
        Employee employee2 = new Employee("Sofia", "Antonova", "HR", 1200);
        communication.saveEmployee(employee2);

        // Delete employee
        communication.deleteEmployee(9);

    }
}
