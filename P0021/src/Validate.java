/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Bảo Châu
 */
public class Validate {

    Scanner s = new Scanner(System.in);

    public void menu() {
        System.out.println("=================================================");
        System.out.println("         WELCOME TO STUDENT MANAGEMENT          ");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("==================================================");
    }

    public int getChoice() {
        int choice;
        while (true) {
            System.out.print("Your choice: ");
            try {
                choice = Integer.parseInt(s.nextLine());
                if (choice >= 1 && choice <= 5) {
                    break;
                } else {
                    System.out.println("Please input again 1-->5!!!");
                }
            } catch (Exception e) {
                System.err.println("Invalid,please input again!!!");
            }
        }
        return choice;
    }

    //check dau vao cho ID
    public String getId() {
        String ID;
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
        while (true) {
            System.out.print("Enter Id Student: ");
            ID = s.nextLine();
            ID = ID.trim().replaceAll("\\s+", "");
            if (p.matcher(ID).find()) {
                ID = ID.toUpperCase();
                break;
            } else {
                System.out.println("Invalid,please input again!!!");
            }
        }
        return ID;
    }

    //check dau vao cho student Name
    public String getStudentName() {
        String studentName;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        while (true) {
            System.out.print("Enter name Student: ");
            studentName = s.nextLine();
            studentName = studentName.trim().replaceAll("\\s+", " ");
            if (p.matcher(studentName).find()) {
                studentName = toProper(studentName);
                break;
            } else {
                System.out.println("Invalid,please input again!!!");
            }
        }
        return studentName;
    }

    //check dau vao cho Semester
    public String getSemester() {
        String semester;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        while (true) {
            System.out.print("Enter semester Student: ");
            semester = s.nextLine();
            semester = semester.trim().replaceAll("\\s+", "");
            if (p.matcher(semester).find()) {
                semester = toProper(semester);
                break;
            } else {
                System.out.println("Invalid,please input again!!!");
            }
        }
        return semester;
    }

    //check dau vao cho course name
    public String getCourseName() {
        String course;
        while (true) {
            System.out.print("Enter course name(Java;.Net;C/C++): ");
            course = s.nextLine();
            course = course.trim().replaceAll("\\s+", " ");
            if (course.equalsIgnoreCase("Java")) {
                course = toProperWord(course);
                break;
            } else if (course.equalsIgnoreCase(".Net")) {
                course = toUpperWord(course);
                break;
            } else if (course.equalsIgnoreCase("C/C++")) {
                course = course.toUpperCase();
                break;
            } else {
                System.out.println("Course name must be Java,.Net or C/C++");
            }
        }
        return course;
    }

    //check yes no
    public String getYN() {

        String choose;
        while (true) {
            System.out.print("Do you want to continue (Y/N)? : ");
            choose = s.nextLine();
            choose = choose.replaceAll("\\s+", " ");
            if (choose.equalsIgnoreCase("y")) {
                return "Y";
            } else if (choose.equalsIgnoreCase("N")) {
                return "N";
            } else {
                System.out.println("Invalid,please input again!!");
            }
        }
    }

    //check xem ID ton tai chua
    public boolean checkExistId(String xId, ArrayList<Student> list) {
        for (Student s : list) {
            if (s.getId().equalsIgnoreCase(xId)) {
                return true;
            }

        }
        return false;
    }

    //check xem student da ton tai chua
    public boolean checkExistStudent(String xId, String xStudentName, String xSemester, String xCourseName, ArrayList<Student> list) {
        for (Student s : list) {
            if (xId.equalsIgnoreCase(s.getId()) && xStudentName.equalsIgnoreCase(s.getStudentName())
                    && xSemester.equalsIgnoreCase(s.getSemester()) && xCourseName.equalsIgnoreCase(s.getCourseName())) {
                return true;
            }
        }
        return false;
    }

    //check UD
    public String getUD() {
        String choose;
        while (true) {
            System.out.print("Do you want to update (U) or delete (D) student(U/D)? : ");
            choose = s.nextLine();
            choose = choose.trim().replaceAll("\\s+", " ");
            if (choose.equalsIgnoreCase("u")) {
                return "U";
            } else if (choose.equalsIgnoreCase("D")) {
                return "D";
            } else {
                System.out.println("Invalid,please input again!!!");
            }
        }
    }

    // check choiceUpdate
    public int getChoiceUpdate(int a, int b) {
        int x;
        while (true) {
            try {
                x = Integer.parseInt(s.nextLine());
                if (x >= a && x <= b) {
                    break;
                } else {
                    System.out.print("Invalid input, try again : ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input, try again : ");
            }

        }
        return x;
    }

    //Ham nhap Name de update
    public String getNameUpdate() {
        String xName;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        while (true) {
            System.out.print("Enter name Student: ");
            xName = s.nextLine();
            xName = xName.trim().replaceAll("\\s+", " ");
            if (!xName.isEmpty()) {
                if (p.matcher(xName).find()) {
                    xName = toProper(xName);
                    break;
                } else {
                    System.out.println("Invalid,please input again!!!");
                }
            } else {
                xName = null;
                break;
            }

        }
        return xName;
    }

    //ham nhap Semester de update
    public String getSemesterUpdate() {
        String xSemester;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        while (true) {
            System.out.print("Enter Semester Student: ");
            xSemester = s.nextLine();
            xSemester = xSemester.trim().replaceAll("\\s+", " ");
            if (!xSemester.isEmpty()) {
                if (p.matcher(xSemester).find()) {
                    xSemester = toProper(xSemester);
                    break;
                } else {
                    System.out.println("Invalid,please input again!!!");
                }
            } else {
                xSemester = null;
                break;
            }

        }
        return xSemester;
    }

    public String getCourseUpdate() {
        String course;
        while (true) {
            System.out.print("Enter course name(Java;.Net;C/C++): ");
            course = s.nextLine();
            course = course.trim().replaceAll("\\s+", " ");
            if (!course.isEmpty()) {
                if (course.equalsIgnoreCase("Java")) {
                    course = toProperWord(course);
                    break;
                } else if (course.equalsIgnoreCase(".Net")) {
                    course = toUpperWord(course);
                    break;
                } else if (course.equalsIgnoreCase("C/C++")) {
                    course = course.toUpperCase();
                    break;
                } else {
                    System.out.println("Course name must be Java,.Net or C/C++");
                }
            } else {
                course = null;
                break;
            }

        }
        return course;
    }

    //check totalCourse xem ton tai chua
    public boolean checkTotalExist(String xName, String xCourseString, int xTotal, ArrayList<TotalCourse> t) {
        for (TotalCourse x : t) {
            if (xName.equalsIgnoreCase(x.getStudentName()) && xCourseString.equalsIgnoreCase(x.getCourseName()) && xTotal == x.getTotalCourse()) {
                return true;
            }
        }
        return false;
    }

    //viet hoa vi tri i=1 trong tu
    public String toUpperWord(String word) {
        String u = "";
        for (int i = 0; i < word.length(); i++) {
            if (i == 1) {
                u += Character.toUpperCase(word.charAt(1));
                continue;
            } else {
                u += "" + Character.toLowerCase(word.charAt(i));
            }

        }
        return u;
    }

    public String[] split(String word) {
        word = word.trim();
        String a[] = word.split("\\s+");
        return a;
    }

    public String toProperWord(String word) {
        String u = "" + Character.toUpperCase(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            u += "" + Character.toLowerCase(word.charAt(i));
        }
        return u;
    }

    public String toProper(String s) {
        String a[] = split(s);
        String u = "" + toProperWord(a[0]);
        for (int i = 1; i < a.length; i++) {
            u += " " + toProperWord(a[i]);
        }
        return u;
    }

}
