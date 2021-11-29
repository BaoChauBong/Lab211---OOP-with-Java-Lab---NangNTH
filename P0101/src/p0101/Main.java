/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0101;

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
        Validate v = new Validate();
        Manager m = new Manager();
        int choice;
        while (true) {
            v.menu();
            choice = v.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("------------------- Add Employees --------------------");
                    String xId = v.getId(m.list);
                    String xFirstName = v.getFirstName();
                    String xLastName = v.getLastName();
                    String xPhone = v.getPhone();
                    String xEmail = v.getEmail();
                    String xAddress = v.getAddress();
                    String xDOB = v.getDOB();
                    String xSex = v.getSex();
                    int xSalary = v.getSalary();
                    String xEgency = v.getEgency();
                    m.addEmployee(xId, xFirstName, xLastName, xPhone, xEmail, xAddress, xDOB, xSex, xSalary, xEgency);
                    break;
                case 2:
                    System.out.println("-------------------- Update Employees -------------------");
                    String xIdUpdate = v.getIdUpdate();
                    boolean check = true;
                    int size = m.list.size();
                    for (int i = 0; i < size; i++) {
                        if (m.list.get(i).getId().equalsIgnoreCase(xIdUpdate)) {
                            String xId1 = v.getId(m.list);
                            String xFirstName1 = v.getFirstName();
                            String xLastName1 = v.getLastName();
                            String xPhone1 = v.getPhone();
                            String xEmail1 = v.getEmail();
                            String xAddress1 = v.getAddress();
                            String xDOB1 = v.getDOB();
                            String xSex1 = v.getSex();
                            int xSalary1 = v.getSalary();
                            String xEgency1 = v.getEgency();
                            check = false;
                            m.updateEmployee(xIdUpdate, xId1, xFirstName1, xLastName1, xPhone1, xEmail1, xAddress1, xDOB1, xSex1, xSalary1, xEgency1);
                            break;
                        }

                    }
                    if (check == true) {
                        System.out.printf("Id = %s not existed.\n", xIdUpdate);
                    }

                    break;
                case 3:
                    System.out.println("---------- DELETE ----------");
                    String xIdDelete = v.getIdDelete();
                    m.deleteEmployee(xIdDelete);
                    break;
                case 4:
                    System.out.println("---------- SEARCH ----------");
                    String xNameSearch = v.getNameSearch();
                    m.searchEmployee(xNameSearch);
                    break;
                case 5:
                    System.out.println("---------- SORT ----------");
                    m.sortEmployees();
                    break;
                case 6:
                    System.out.println("---------- DISPLAY ----------");
                    m.displayEmployee();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
