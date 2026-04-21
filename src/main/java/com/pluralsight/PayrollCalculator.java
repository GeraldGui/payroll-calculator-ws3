package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PayrollCalculator {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        String line;

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                String[] tokens = line.split("\\|");

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                employees.add(new Employee(employeeId, name, hoursWorked, payRate));

            }
            for (Employee makeEmployee : employees) {
                System.out.printf("Employee ID: " + makeEmployee.getEmployeeId() + " \nName: " + makeEmployee.getName() + "\nPay: " + makeEmployee.getGrossPay() + "\n------------------------\n");

                bufferedReader.close();
            }
        } catch (Exception ex) {
            System.out.println("Wrong Input!");
        }
    }
}
