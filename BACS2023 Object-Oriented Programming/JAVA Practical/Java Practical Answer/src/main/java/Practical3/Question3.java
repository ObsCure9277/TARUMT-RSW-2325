/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Practical3;


import java.util.Scanner;
        
public class Question3 {

    public static void getQuantity(int[] denom, int[] qty) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Denomination (RM) Quantity");
        for (int i = 0; i < denom.length; i++) {

            System.out.printf("%12d %9s", denom[i], "");
            qty[i] = scan.nextInt();
        }
    }
    
    public static void displayResult(int[] denom, int[] qty) {
        System.out.printf("%s %15s %15s\n", "Denomination(RM)", "Quantity", "Value(RM)");
        
        int total=0;
        for (int i = 0; i < denom.length; i++) {
            if (qty[i] != 0) {
                System.out.printf("%14d %15d %15d \n", denom[i], qty[i], denom[i] * qty[i]);
                total += (denom[i] * qty[i]);
            }
        }
        System.out.println("Total = RM" + total);
    }
    
    public static void main(String[] args) {
        int[]denom = {100, 50, 20, 10, 5, 1};
        int[]quantity = new int [denom.length];
        
        getQuantity(denom,quantity);
        System.out.println();
        displayResult(denom, quantity);
    }
}
