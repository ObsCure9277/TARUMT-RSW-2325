/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Practical4;

/**
 *
 * @author Ng Shen Zhi
 */
public class StudentQuiz {
    
    public static void main(String args[]) {
        Student s = new Student("W0001","Alex");
    
        s.addQuiz(8);
        s.addQuiz(10);
 
        s.setTotal(100);
        
        System.out.println("Total Score : " + s.getTotalScore());
        System.out.println("Average Score : " + s.getAverageScore());
        System.out.println("Quizzes Taken : " + s.getQuizCount());
    }
}
