/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Practical4B;

import java.util.Scanner;

public class TestRegistration {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Registration[] regList = new Registration[2];

        CarType[] typeList = {
            new CarType("Toyota", "Vios", 1.5),
            new CarType("Nissan", "Teana", 2.0),
            new CarType("Honda", "City", 1.6)
        };

        for (int count = 0; count < regList.length; count++) {
            for (int i = 0; i < typeList.length; i++) {
                System.out.println((i + 1) + " " + typeList[i].toString());
            }

            System.out.println("Enter selection : ");
            int selection = scan.nextInt();

            //todo:: car info
            System.out.println("Enter Plate No. : ");
            String plate = scan.next();

            System.out.println("Enter Color : ");
            String color = scan.next();

            System.out.println("Enter Year : ");
            int year = scan.nextInt();

            Car car = new Car(plate, color, year, typeList[selection - 1]);

            //todo:: get owner info
            scan.nextLine();
            System.out.println("Enter Owner Name : ");
            String name = scan.nextLine();

            System.out.println("Enter Owner IC : ");
            String ic = scan.next();

            Owner owner = new Owner(name, ic);

            Registration reg = new Registration(owner, car);

            regList[count] = reg;

            System.out.println("");
        }

        System.out.println();
        System.out.println("\t\t\t Car Registration Listing");
        System.out.printf("%-8s %-15s %-14s %-8s %-8s %-6s %-8s %-8s %-5s\n",
                "Reg #", "Name", "IC #",
                "Plate #", "Color", "Year",
                "Brand", "Model", "Capacity");
        for (Registration reg : regList) {
            System.out.println(reg.toString());
        }
    }
}
