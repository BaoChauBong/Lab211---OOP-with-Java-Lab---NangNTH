/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bảo Châu
 */
public class Student {
    public String Id;
    public String studentName;
    public String semester;
    public String courseName;

    public Student() {
    }

    public Student(String Id, String studentName, String semester, String courseName) {
        this.Id = Id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }
    
    public Student(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    @Override
    public String toString() {
        return String.format("%-5s%-20s%-15s%-10s",Id, studentName,semester,courseName);
    }

    
    
    
}
