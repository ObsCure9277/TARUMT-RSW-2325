/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical4B;

/**
 *
 * @author Ng Shen Zhi
 */
public class Registration {

    private static int currentRegNo = 1001;
    private int regNo;
    private Owner owner;
    private Car car;

    public Registration(Owner owner, Car car) {
        this.regNo = currentRegNo;
        this.owner = owner;
        this.car = car;
        currentRegNo++;
    }

    public String toString() {
        return String.format("%-8d %s %s", regNo, owner, car);
    }

}
