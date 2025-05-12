/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical4;

/**
 *
 * @author Ng Shen Zhi
 */
public class TestEmployee {
    
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee("Alex");
        
        emp1.setName("John");
        emp1.setSalary(5000);
        
        //........
        emp2.setSalary(8000);

        if (emp1.getSalary() > emp2.getSalary()) {
            System.out.println("Employee with higher salary: " + emp1.getName());
        } else {
            System.out.println("Employee with higher salary: " + emp2.getName());
        }
        
        double total = emp1.getSalary() + emp2.getSalary();
        
        System.out.println("Total salary: RM" + total);
        
        /*
        //part A
        System.out.println("Salary before raise 8% : " + emp1.getSalary());
        
        emp1.raiseSalary(8);
        
        System.out.println("Salary before raise 8% : " + emp1.getSalary());
        */
    }
}
    
