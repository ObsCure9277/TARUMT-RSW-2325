/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Pratical1;

/**
 *
 * @author Ng Shen Zhi
 */

import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        // Prompt the user to enter an 8-digit number
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an 8-digit number: ");
        int creditCardNumber = scanner.nextInt();
        scanner.close();

        // Validate the credit card number
        boolean isValid = isValidCreditCard(creditCardNumber);
        
        // Print the result
        if (isValid) {
            System.out.println("The credit card number is valid.");
        } else {
            int checkDigit = calculateCheckDigit(creditCardNumber);
            System.out.println("The credit card number is not valid.");
            System.out.println("The check digit that would make it valid is: " + checkDigit);
        }
    }

    // Method to validate the credit card number
    public static boolean isValidCreditCard(int number) {
        int sumOfDigits = sumOfEveryOtherDigit(number) + sumOfDoubledDigits(number);
        return sumOfDigits % 10 == 0;
    }

    // Method to calculate the sum of every other digit from the rightmost digit
    public static int sumOfEveryOtherDigit(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 100; // Move to every other digit
        }
        return sum;
    }

    // Method to calculate the sum of doubled digits and their individual digits
    public static int sumOfDoubledDigits(int number) {
        int sum = 0;
        number /= 10; // Start from the next-to-last digit
        while (number > 0) {
            int doubledDigit = (number % 10) * 2;
            sum += (doubledDigit % 10) + (doubledDigit / 10); // Add individual digits of doubledDigit
            number /= 100; // Move to every other digit
        }
        return sum;
    }

    // Method to calculate the check digit that would make the credit card number valid
    public static int calculateCheckDigit(int number) {
        int sumOfEveryOther = sumOfEveryOtherDigit(number);
        int sumOfDoubledDigits = sumOfDoubledDigits(number);
        int totalSum = sumOfEveryOther + sumOfDoubledDigits;
        return (totalSum * 9) % 10;
    }
}

 