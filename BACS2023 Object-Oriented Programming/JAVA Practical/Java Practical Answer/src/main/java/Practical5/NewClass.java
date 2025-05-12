/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical5;

import java.util.Scanner;

public class NewClass {

    public static int countLetter(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char temp = Character.toUpperCase(str.charAt(i));
            if (temp == Character.toUpperCase(ch)) {
                count++;
            }
        }
        return count;
    }
     public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a word: " );
        String word = scan.next();
        
        System.out.print("Enter the letter you want to count: " );
        char letter = scan.next().charAt(0);
        
        int count = countLetter(word, letter);
        
        System.out.printf("%s contains %d%c\n", word, count, letter);
    }
}
