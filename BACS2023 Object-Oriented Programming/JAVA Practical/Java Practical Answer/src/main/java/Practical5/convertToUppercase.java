/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical5;

import java.util.Scanner;

public class convertToUppercase {
      public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = scan.nextLine();
        str = str.toUpperCase();

        //method 1
        str = str.replaceAll("A", "x");
        str = str.replaceAll("E", "x");
        str = str.replaceAll("I", "x");
        str = str.replaceAll("O", "x");
        str = str.replaceAll("U", "x");

        //method 2
        String[] vowels = {"A", "E", "I", "O", "U"};
        for (int i = 0; i < vowels.length; i++) {
            str = str.replaceAll(vowels[i], "x");
        }
	
        //method 3
        str = str.replaceAll("[AEIOU]", "x");

        System.out.println("Modified string: " + str);
    }
}
