/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Bảo Châu
 */
public class Manager {

    ArrayList<Employee> list = new ArrayList<>();

    //add
    public void addEmployee(String xId, String xFirstName, String xLastName, String xPhone, String xEmail,
            String xAddress, String xDOB, String xSex, int xSalary, String xEgency) {
        list.add(new Employee(xId, xFirstName, xLastName, xPhone, xEmail, xAddress, xDOB, xSex, xSalary, xEgency));
        System.out.println("Add successful!!!");
    }

    public void updateEmployee(String idUpdate, String xId, String xFirstName, String xLastName, String xPhone, String xEmail,
            String xAddress, String xDOB, String xSex, int xSalary, String xEgency) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(idUpdate)) {
                list.get(i).setId(xId);
                list.get(i).setFirstName(xFirstName);
                list.get(i).setLastName(xLastName);
                list.get(i).setPhone(xPhone);
                list.get(i).setEmail(xEmail);
                list.get(i).setAddress(xAddress);
                list.get(i).setDOB(xDOB);
                list.get(i).setSex(xSex);
                list.get(i).setSalary(xSalary);
                list.get(i).setEgency(xEgency);
                System.out.println("Successful!");
                break;
            }

        }
    }

    public void deleteEmployee(String idDelete) {
        boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(idDelete)) {
                list.remove(i);
                check = false;
                System.out.println("Successful!");
                break;
            }
        }
        if (check == true) {
            System.out.println("Fail!");
        }
    }

    public void searchEmployee(String nameSearch) {
        boolean check = true;
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-15s%-10s%-10s%-10s\n",
                "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency\n");
        for (Employee e : list) {
            if (e.getFirstName().equalsIgnoreCase(nameSearch) || e.getLastName().equalsIgnoreCase(nameSearch)
                    || e.getFirstName().toLowerCase().contains(nameSearch.toLowerCase())
                    || e.getLastName().toLowerCase().contains(nameSearch.toLowerCase())) {
                System.out.println(e);
                check = false;
                break;
            }
        }
        if (check == true) {
            System.err.println("Not found employees need search");
        }
    }

    public void sortEmployees() {
        if (list.isEmpty()) {
            System.out.println("Not have infomation employees");
        } else {
            Collections.sort(list, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o1.Salary - o2.Salary;
                }
            });
            System.out.println("Successful!");
        }

    }

    public void displayEmployee() {
        if (list.isEmpty()) {
            System.err.println("Not infomation!!!");
        } else {
            System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-15s%-10s%-10s%-10s\n",
                    "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency\n");
            for (Employee e : list) {
                System.out.println(e);
            }
        }

    }
}
