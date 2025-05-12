/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Practical4;

/**
 *
 * @author Ng Shen Zhi
 */
public class Employee {

    private String name;
    private double salary;

    public Employee() {
        name = "";
        salary = 0;
    }

    public Employee(String n) {
        name = n;
        salary = 0;
    }

    public Employee(String employeeName, double currentSalary) {
        name = employeeName;
        salary = currentSalary;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double s) {
        salary = s;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double percent) {
        salary = salary + (salary * percent / 100.0);
    }
}
