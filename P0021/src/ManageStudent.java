/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Bảo Châu
 */
public class ManageStudent {

    ArrayList<Student> list = new ArrayList<>();
    Validate v = new Validate();

    public void add() {
        list.add(new Student("1", "Nguyen Van A", "Spring", "Java"));
        list.add(new Student("1", "Nguyen Van A", "Spring", ".Net"));
        list.add(new Student("1", "Nguyen Van A", "Summer", ".Net"));
        list.add(new Student("2", "Nguyen Van A", "Summer", ".Net"));
        list.add(new Student("2", "Tran B", "Spring", ".Net"));
        list.add(new Student("3", "Le Thi C", "Spring", "C/C++"));
        list.add(new Student("4", "Do Van An", "Summer", ".Net"));
        list.add(new Student("5", "Le D", "Summer", "Java"));
        list.add(new Student("5", "Le D", "Spring", ".Net"));
        ////        list.add(new Student("5", "Le D", "Summer", ".Net"));
        ////        list.add(new Student("6", "Phan E", "Summer", ".Net"));
    }

    public void Create(String Id, String studentName, String semester, String courseName) {
        list.add(new Student(Id, studentName, semester, courseName));
        System.out.println("Create successful!!!");
    }

    public void display(ArrayList<Student> list) {
        System.out.printf("%-5s%-20s%-15s%-10s\n", "ID", "Student Name", "Semester", "Course Name");
        for (Student e : list) {
            System.out.println(e);
        }

    }

    //find and Sort
    public void findAndSort(String xStudentName) {
        ArrayList<Student> list1 = searchByName(xStudentName);
        sortByName(list1);
        System.out.println("------------------Result-----------------------");
        display(list1);
    }

    //Ham tim kiem name de sap xep
    public ArrayList<Student> searchByName(String studentName) {
        ArrayList<Student> list1 = new ArrayList<>();
        boolean check = true;
        for (Student e : list) {
            if (e.getStudentName().toUpperCase().contains(studentName.toUpperCase())) {
                check = false;
                break;
            }
        }
        if (check == true) {
            System.out.println("Not found name student need search!!!");
            return null;
        } else {
            for (Student e : list) {
                if (e.getStudentName().toUpperCase().contains(studentName.toUpperCase())) {
                    list1.add(e);
                }
            }
        }
        return list1;
    }

    //ham sap xep list theo Ten
    public void sortByName(ArrayList<Student> list) {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareToIgnoreCase(o2.getStudentName());
            }
        });
    }

    //update
    public void updateAndDelete(String xId) {
        String ud;
        ArrayList<Student> list1 = searchById(xId);
        if (list1 != null) {
            System.out.println("\nRESULT: ");
            displayLine(list1);

            int size = list1.size();

            ud = v.getUD();
            if (ud.equalsIgnoreCase("U")) {
                System.out.printf("Enter the line you want to update ( 1 -> %d ) : ", size);
                int choice = v.getChoiceUpdate(1, size);// choice la index cua student trong s12
                int index = getStudentFromListSearch(list, list1.get(choice - 1));
                if (size == 1) {
                    String xName = v.getNameUpdate();
                    String xSemester = v.getSemesterUpdate();
                    String xCourse = v.getCourseUpdate();
                    if (xName == null) {
                        xName = list.get(index).getStudentName();
                    } else {
                        list.get(index).setStudentName(xName);
                    }

                    if (xSemester == null) {
                        xSemester = list.get(index).getSemester();
                    } else {
                        list.get(index).setSemester(xSemester);
                    }

                    if (xCourse == null) {
                        xCourse = list.get(index).getCourseName();
                    } else {
                        list.get(index).setCourseName(xCourse);
                    }
                    if (v.checkExistStudent(xId, xName, xSemester, xCourse, list) == true) {
                        System.out.println("The data was uploaded before!");
                        xName = list.get(index).getStudentName();
                        xSemester = list.get(index).getSemester();
                        list.get(index).setCourseName(xCourse);

                    }

                }

                if (size > 1) {
                    String xID = list.get(index).getId();
                    String xName = list.get(index).getStudentName();
                    String xSemester = v.getSemesterUpdate();
                    String xCourse = v.getCourseUpdate();
                    if (xSemester == null) {
                        xSemester = list.get(index).getSemester();
                    }
                    if (xCourse == null) {
                        xCourse = list.get(index).getCourseName();
                    }

                    if (v.checkExistStudent(xID, xName, xSemester, xCourse, list) == true) {
                        xSemester = list.get(index).getSemester();
                        xCourse = list.get(index).getCourseName();
                        System.out.println("The data was uploaded before!");
                        display(list);
                        return;
                    }

                    if (xSemester == null) {
                        xSemester = list.get(index).getSemester();
                    } else {
                        list.get(index).setSemester(xSemester);
                    }

                    if (xCourse == null) {
                        xCourse = list.get(index).getCourseName();
                    } else {
                        list.get(index).setCourseName(xCourse);
                    }

                }
                System.out.println("Update successfully!");
                System.out.println("\nRESULT");
                display(list);

            }
            //remove
            if (ud.equalsIgnoreCase("D")) {
                System.out.printf("Enter the line you want to delete ( 1 -> %d ): ", size);
                int choice = v.getChoiceUpdate(1, size);
                int index = getStudentFromListSearch(list, list1.get(choice - 1));
                list.remove(list.get(index));
                System.out.println("Remove successfully!");
                System.out.println("\nRESULT");
                display(list);
            }
        }

    }

    //tim kiem ID de Update hoac Delete
    public ArrayList<Student> searchById(String xID) {
        ArrayList<Student> list1 = new ArrayList<>();
        boolean check = true;
        for (Student e : list) {
            if (e.getId().toUpperCase().contains(xID.toUpperCase())) {
                check = false;
                break;
            }
        }
        if (check == true) {
            System.out.println("Not found ID student need search!!!");
            return null;
        } else {
            for (Student e : list) {
                if (e.getId().toUpperCase().contains(xID.toUpperCase())) {
                    list1.add(e);
                }
            }
        }
        return list1;
    }

    //Ham tim kiem index cua Student trong list
    public int getStudentFromListSearch(ArrayList<Student> list, Student x) {
        int i;
        for (i = 0; i < 10; i++) {
            if (list.get(i).getId().equalsIgnoreCase(x.getId())
                    && list.get(i).getStudentName().equalsIgnoreCase(x.getStudentName())
                    && list.get(i).getSemester().equalsIgnoreCase(x.getSemester())
                    && list.get(i).getCourseName().equalsIgnoreCase(x.getCourseName())) {
                break;
            }
        }
        return i;
    }

    // report
    public void report() {
        ArrayList<TotalCourse> tc = new ArrayList<>();
        String xName;
        String xCourse;
        int i;
        for (Student s1 : list) {
            int total = 0;
            xName = s1.getStudentName();
            xCourse = s1.getCourseName();
            for (Student s2 : list) {
                if (s1.getId().equalsIgnoreCase(s2.getId())
                        && s1.getStudentName().equalsIgnoreCase(s2.getStudentName())
                        && s1.getCourseName().equalsIgnoreCase(s2.getCourseName())) {
                    total++;
                }
            }
            if (v.checkTotalExist(xName, xCourse, total, tc) == false) {
                tc.add(new TotalCourse(xName, xCourse, total));
            }
        }
        for (TotalCourse e : tc) {
            e.display();
            System.out.println("");
        }
    }

    public void displayLine(ArrayList<Student> list) {
        int Stt = 1;
        System.out.printf("%-5s%-5s%-20s%-15s%-10s\n", "STT", "ID", "Student Name", "Semester", "Course Name");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-5d%-5s%-20s%-15s%-10s", Stt, list.get(i).getId(),
                    list.get(i).getStudentName(), list.get(i).getSemester(), list.get(i).getCourseName());
            System.out.println("");
            Stt++;
        }
    }
}
