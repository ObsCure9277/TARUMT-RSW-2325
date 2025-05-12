/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical7B;

/**
 *
 * @author Ng Shen Zhi
 */
public class ComparableCircle extends Circle implements Comparable<ComparableCircle>, Colorable {

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        double r1 = this.getRadius();
        double r2 = o.getRadius();

        return Double.compare(r1, r2);
    }

    @Override
    public void howToColor() {
        System.out.println("Colour it with red colour");
    }
}


