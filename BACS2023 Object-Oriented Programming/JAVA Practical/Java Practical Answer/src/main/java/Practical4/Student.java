/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical4;

/**
 *
 * @author Ng Shen Zhi
 */
public class Student {

    private String id;
    private String name;
    private int quizCount;
    private int totalScore;

    public void Student() {
        id = "";
        name = "";
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public double getQuizCount() {
        return quizCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal(int totalScore) {
        this.totalScore = totalScore;
    }

    public double getAverageScore() {
        return (double) totalScore / quizCount;
    }

    public void addQuiz(int score) {
        if (score > 10) {
            System.err.println("Invalid Score : " + score);
        } else {
            quizCount++;
            totalScore += 10;
        }
    }
}
