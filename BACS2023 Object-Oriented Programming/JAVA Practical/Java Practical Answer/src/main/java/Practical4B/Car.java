/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Practical4B;

/**
 *
 * @author Ng Shen Zhi
 */
public class Car {

    private String plateNo;
    private String color;
    private int year;
    private CarType carType;

    public Car(String plateNo, String color, int year, CarType carType) {
        this.plateNo = plateNo;
        this.color = color;
        this.year = year;
        this.carType = carType;
    }

    public String toString() {
        return String.format("%-6s %-8s %-6s %s", plateNo, color, year, carType);
    }
}
