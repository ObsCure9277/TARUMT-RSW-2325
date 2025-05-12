/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Pratical1;

/**
 * @author Ng Shen Zhi
 */

import java.util.Scanner;

public class Question1 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your year of study: ");
        int yearOfStudy = scanner.nextInt();
        
        System.out.print("What is your target GPA for this semester? ");
        double gpa = scanner.nextDouble();
        
        System.out.println();
        System.out.println("Welcome " + name + "!");
        System.out.println("Work hard to achieve your target GPA of " + gpa + " this semester of your Year " + yearOfStudy + ".");
    }
}
