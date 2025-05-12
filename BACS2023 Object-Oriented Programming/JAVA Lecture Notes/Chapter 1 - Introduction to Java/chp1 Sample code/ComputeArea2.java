// Filename: ComputeArea2.java

import java.util.Scanner;

public class ComputeArea2 {
    public static void main(String[] args) {
        final double PI = 3.14159;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        double radius = scanner.nextDouble();
        
        double area = radius * radius * PI;
        
        System.out.println("The area for the circle of radius " + 
                radius + " is " + area);
    }

}
