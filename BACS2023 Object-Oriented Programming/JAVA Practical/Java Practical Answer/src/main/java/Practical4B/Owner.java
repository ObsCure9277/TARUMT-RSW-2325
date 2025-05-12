/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical4B;

/**
 *
 * @author Ng Shen Zhi
 */
public class Owner {

    private String name;
    private String ic;

    public Owner(String name, String ic) {
        this.name = name;
        this.ic = ic;
    }

    public String toString() {
        return String.format("%-15s %-14s", name, ic);
    }
}
