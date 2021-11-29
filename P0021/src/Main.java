/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Bảo Châu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        Validate v = new Validate();
        ManageStudent t = new ManageStudent();
        t.add();
        while (true) {
            v.menu();
            int choice = v.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("-------------------Create Student--------------------");
                    String xId,
                     xStudentName = null,
                     xSemester,
                     xCourseName;
                    while (true) {
                        xId = v.getId();
                        if (v.checkExistId(xId, t.list) == true) {//neu Id do ton tai thi gan luon cai studentName tuong ung vs ID do
                            for (Student s1 : t.list) {
                                if (s1.getId().equalsIgnoreCase(xId)) {
                                    xStudentName = s1.getStudentName();
                                }
                            }
                        } else {
                            xStudentName = v.getStudentName();
                        }

                        xSemester = v.getSemester();
                        xCourseName = v.getCourseName();
                        if (v.checkExistStudent(xId, xStudentName, xSemester, xCourseName, t.list) == true) {
                            System.out.println("The data was uploaded before!");
                        } else {
                            t.Create(xId, xStudentName, xSemester, xCourseName);
                        }

                        if (t.list.size() >= 10) {
                            String yn = v.getYN();
                            if (yn.equals("N")) {
                                break;
                            }
                        }
                    }
                    t.display(t.list);
                    break;

                case 2:
                    System.out.println("----------------------Find and Sort Student----------------------- ");
                    String nameSearch = v.getStudentName();
                    t.findAndSort(nameSearch);
                    break;

                case 3:
                    System.out.println("----------------------Update/Delete------------------------------- ");
                    String idSearch = v.getId();
                    t.updateAndDelete(idSearch);
                    break;
                case 4:
                    System.out.println("------------------------Report------------------------------");
                    t.report();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

}
