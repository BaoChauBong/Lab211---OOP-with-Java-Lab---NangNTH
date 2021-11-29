/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NITRO
 */
public class TotalCourse extends Student {

    public int totalCourse;

    public TotalCourse() {
    }

    public TotalCourse(String Id, String studentName, String semester, String courseName, int totalCourse) {
        super(Id, studentName, semester, courseName);
        this.totalCourse = totalCourse;
    }

    public TotalCourse(String studentName, String courseName, int totalCourse) {
        super(studentName, courseName);
        this.totalCourse = totalCourse;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public void display() {
        System.out.printf("%-15s | %-10s | %-5d", super.getStudentName(), super.getCourseName(), getTotalCourse());
    }
}
