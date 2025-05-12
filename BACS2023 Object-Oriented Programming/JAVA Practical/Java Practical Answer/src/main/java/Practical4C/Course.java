/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical4C;

/**
 *
 * @author Ng Shen Zhi
 */
public class Course {
    private String courseTitle;
    private double feesPerStudent;
    private int noOfStudents;
    private String[] studentNames;
    private static int courseCount;

    public Course(String courseTitle, double feesPerStudent) {
        this.courseTitle = courseTitle;
        this.feesPerStudent = feesPerStudent;
        studentNames = new String[100];
        courseCount++;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getFeesPerStudent() {
        return feesPerStudent;
    }

    public void setFeesPerStudent(double feesPerStudent) {
        this.feesPerStudent = feesPerStudent;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String[] getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(String[] studentNames) {
        this.studentNames = studentNames;
    }

    public static int getCourseCount() {
        return courseCount;
    }

    public static void setCourseCount(int courseCount) {
        Course.courseCount = courseCount;
    }

    public double calcFeesCollected() {
        return feesPerStudent * noOfStudents;
    }

    public void addStudent(String name) {
        studentNames[noOfStudents] = name;
        noOfStudents++;
    }

    public String toString() {
        return "Course Title: " + courseTitle + "\n"
                + "Fees per Student: " + feesPerStudent + "\n"
                + "Number of Students: " + noOfStudents;
    }
}
