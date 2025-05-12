/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Practical2;

/**
 *
 * @author Ng Shen Zhi
 */
import java.util.Scanner;

public class Question1 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        float sqrt =  (float) Math.sqrt(number);
        
        System.out.println("Square root of " + number + " is " + sqrt + ".");
    }
}
