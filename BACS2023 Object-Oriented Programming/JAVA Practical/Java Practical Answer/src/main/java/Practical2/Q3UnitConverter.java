/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Practical2;

/**
 *
 * @author Ng Shen Zhi
 */

public class Q3UnitConverter {
    
    public static double inchToCentimeter(double in){
        return in * 2.54;
    }
    
    public static double centimeterToInch(double cm){
        return cm / 2.54;
    }
    
    public static void main(String args[]) {
        
        System.out.println("Inches\tCentimeters\tCentimeters\tInches");
        System.out.println();

        for (int i = 1; i <= 10; i++) {
            double inches = i;
            double centimeters = inchToCentimeter(inches);
            double centimeter = inches * 5;
            double inch = centimeterToInch(centimeter);
            System.out.printf("%.1f\t%.2f\t\t%.1f\t\t%.2f\n", inches, centimeters, centimeter, inch);
        }
    }
}
