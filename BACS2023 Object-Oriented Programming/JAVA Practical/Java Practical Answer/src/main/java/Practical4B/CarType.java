/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical4B;

/**
 *
 * @author Ng Shen Zhi
 */
public class CarType {

    private String brand;
    private String model;
    private double capacity;

    public CarType(String brand, String model, double capacity) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
    }

    public String toString() {
        return String.format("%-8s %-8s %-5f", brand, model, capacity);
    }
}
