/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Practical3;

/**
 *
 * @author Ng Shen Zhi
 */
public class Question2 {

    public static int findSmallestIndex(int[] arrNo) {
        int smallestIndex = 0;
        for (int i = 1; i < arrNo.length; i++) {
            if (arrNo[i] < arrNo[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
       int[]arrNo = {1,2,4,5,10,100,2,-22}; 
       int index = findSmallestIndex(arrNo);
       
       System.out.println("The index of the smallest element in array is " + index);      
    }
}
