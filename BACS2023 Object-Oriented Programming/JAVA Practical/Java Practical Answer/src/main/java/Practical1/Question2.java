/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Pratical1;

/**
 * @author Ng Shen Zhi
 */

import java.util.Scanner;

public class Question2 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter your age (years): ");
        int age = scanner.nextInt();
        
        System.out.println("Age in years: " + age + " years");
        int days = age*365; 
        
        System.out.println("Age in days: " + days + " days");
        int seconds = days*24*60*60;
        
        System.out.println("Age in seconds: " + seconds +" seconds");
        System.out.println();
        System.out.println("Process completed !");
    }
}
