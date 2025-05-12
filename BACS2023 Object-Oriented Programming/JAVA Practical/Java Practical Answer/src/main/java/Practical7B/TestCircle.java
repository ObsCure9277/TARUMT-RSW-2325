/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical7B;

/**
 *
 * @author Ng Shen Zhi
 */
public class TestCircle {
    public static void main(String[] args){
        
        ComparableCircle c1 = new ComparableCircle(10);
        ComparableCircle c2 = new ComparableCircle(15);
        
        if(c1.compareTo(c2)> 0){
            System.out.println("Circle 1 > Circle 2");
        }else if (c1.compareTo(c2) < 0){
            System.out.println("Circle 2 > Circle 1");
        }else
            System.out.println("Circle 1 and Circle 2 having same radius");
    }
}
