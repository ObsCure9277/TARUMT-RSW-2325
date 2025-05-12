/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical4C;


public class TestCourse {
     public static void main(String[]args){
        
        Course c = new Course("Introduction to Computers", 250);
        
        //add Ali Said, Wong Ken, Peter Lim
        c.addStudent("Ali Said");
        c.addStudent("Wong Ken");
        c.addStudent("Peter Lim");
        
        System.out.println("Total number of Courses: " + Course.getCourseCount());
        System.out.println(c.toString());
        System.out.println("Total Fees Collected: " + c.calcFeesCollected());
        System.out.println("\nStudent list: ");
        
        for(int i=0; i < c.getNoOfStudents(); i++){
            System.out.println(i + 1 + ". " + c.getStudentNames()[i]);
        }
    }
}
