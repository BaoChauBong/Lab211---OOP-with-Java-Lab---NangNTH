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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Bảo Châu
 */
public class Validate {

    Scanner s = new Scanner(System.in);

    public void menu() {
        System.out.println("=====================================================");
        System.out.println("             EMPLOYEE MANAGEMENT SYSTEM              ");
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Display employee");
        System.out.println("0. Exit");
        System.out.println("=====================================================");
    }

    public int getChoice() {

        int choice;
        while (true) {
            System.out.print("Your choice: ");
            try {
                choice = Integer.parseInt(s.nextLine());
                if (choice >= 0 && choice <= 6) {
                    break;
                } else {
                    System.out.println("Please input again 1-->5!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid,please input again!!!");
            }
        }
        return choice;
    }

    //check đầu vào cho ID
    public String getString() {
        System.out.print("Enter ID: ");
        String str;

        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        while (true) {

            str = s.nextLine();
            str = str.trim().replaceAll("\\s+", " ");
            if (str.isEmpty()) {
                System.out.print("Invalid,please input again: ");
            } else if (p.matcher(str).find()) {
                str = str.toUpperCase();
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return str;
    }

    public String getId(ArrayList<Employee> list) {
        String id;

        while (true) {
            boolean check = true;
            id = getString();
            for (Employee e : list) {
                if (e.id.equalsIgnoreCase(id)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return id;
            } else {
                System.out.println("Dublicate code, please input again!!");
            }
        }
    }

    // check đầu vào cho first name
    public String getFirstName() {
        System.out.print("Enter First Name: ");
        String firstName;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        while (true) {
            firstName = s.nextLine();
            firstName = firstName.trim().replaceAll("\\s+", " ");
            if (firstName.isEmpty()) {
                System.out.print("Invalid,please input again: ");
            } else if (p.matcher(firstName).find()) {
                firstName = toProper(firstName);
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return firstName;
    }

    //check đầu vào cho last name
    public String getLastName() {
        System.out.print("Enter Last Name: ");
        String lastName;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        while (true) {
            lastName = s.nextLine();
            lastName = lastName.trim().replaceAll("\\s+", " ");
            if (lastName.isEmpty()) {
                System.out.print("Invalid,please input again: ");
            } else if (p.matcher(lastName).find()) {
                lastName = toProper(lastName);
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return lastName;
    }

    //check đầu vào cho phone
    public String getPhone() {
        System.out.print("Enter phone: ");
        String Phone;
        Pattern p = Pattern.compile("^0[1-9]{8,9}$");
        while (true) {
            Phone = s.nextLine();
            if (Phone.isEmpty()) {
                System.out.print("Invalid,please input again:");
            } else if (p.matcher(Phone).find()) {
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return Phone;
    }

    //Check đầu vào cho email
    public String getEmail() {
        System.out.print("Enter email(email@address.com): ");
        String Email;
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9\\-_]+@[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})+$");
        while (true) {
            Email = s.nextLine();
            if (Email.isEmpty()) {
                System.out.println("Invalid,please input again: ");

            } else if (p.matcher(Email).find()) {
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return Email;
    }

    //Check đầu vào cho address
    public String getAddress() {
        System.out.print("Enter address: ");
        String address;
        Pattern p = Pattern.compile("^[a-zA-Z0-9 ]+$");
        while (true) {
            address = s.nextLine();
            address = address.trim().replaceAll("\\s+", " ");
            if (address.isEmpty()) {
                System.out.print("Invalid,please input again: ");
            } else if (p.matcher(address).find()) {
                address = toProper(address);
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return address;
    }

    //check đầu vào cho DOB
    public String getDOB() {

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        Date date;
        while (true) {
            try {
                System.out.print("Enter DOB(dd-MM-yyyy): ");
                date = df.parse(s.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid,please input again!");
            }
        }
        return df.format(date);
    }

    //check đầu vào cho sex
    public String getSex() {
        String Sex;
        while (true) {
            System.out.print("Enter Sex : ");
            Sex = s.nextLine();
            if (Sex.toLowerCase().equals("nam") || Sex.toLowerCase().equals("male")) {
                break;
            } else if (Sex.toLowerCase().equals("nu") || Sex.toLowerCase().equals("female")) {
                break;
            } else {
                System.out.println("Invalid phone sex!!Sex must be (nam,nu,male,female)!!!");
            }
        }
        return Sex;
    }

    //Check đầu vào cho Salary
    public int getSalary() {
        int salary;

        while (true) {
            try {
                System.out.print("Enter salary: ");
                salary = Integer.parseInt(s.nextLine());
                if (salary >= 0) {
                    break;
                } else {
                    System.out.println("Salary must be >=0");
                }

            } catch (Exception e) {
                System.out.println("Invalid,please input again!!!");
            }
        }
        return salary;
    }

    //check đầu vào cho egency
    public String getEgency() {
        System.out.print("Enter Egency: ");
        String Egency;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        while (true) {
            Egency = s.nextLine();
            Egency = Egency.trim().replaceAll("\\s+", " ");
            if (Egency.isEmpty()) {
                System.out.print("Invalid,please input again: ");
            } else if (p.matcher(Egency).find()) {
                Egency = toProper(Egency);
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return Egency;
    }

    //check ID update
    public String getIdUpdate() {
        System.out.print("Enter Id update: ");
        String idUpdate;
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        while (true) {
            idUpdate = s.nextLine();
            idUpdate = idUpdate.trim().replaceAll("\\s+", " ");
            if (idUpdate.isEmpty()) {
                System.out.print("Invalid,please input again: ");
            } else if (p.matcher(idUpdate).find()) {
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return idUpdate;
    }

    //check ID remove
    public String getIdDelete() {
        System.out.print("Enter Id delete: ");
        String idDelete;
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        while (true) {
            idDelete = s.nextLine();
            idDelete = idDelete.trim().replaceAll("\\s+", " ");
            if (idDelete.isEmpty()) {
                System.out.print("Invalid,please input again: ");
            } else if (p.matcher(idDelete).find()) {
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return idDelete;
    }

    //check name để search
    public String getNameSearch() {
        System.out.print("Enter name need search: ");
        String nameSearch;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        while (true) {
            nameSearch = s.nextLine();
            nameSearch = nameSearch.trim().replaceAll("\\s+", " ");
            if (nameSearch.isEmpty()) {
                System.out.print("Invalid,please input again: ");
            } else if (p.matcher(nameSearch).find()) {
                break;
            } else {
                System.out.print("Invalid,please input again: ");
            }
        }
        return nameSearch;
    }

    public String[] splitWord(String word) {
        word = word.trim();
        String[] a = word.split("[ ]+");
        return a;

    }

    public String toProperWord(String word) {
        String u = "";
        u = "" + Character.toUpperCase(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            u += "" + Character.toLowerCase(word.charAt(i));
        }
        return u;
    }

    public String toProper(String s) {
        String[] a = splitWord(s);
        a[0] = toProperWord(a[0]);
        String u = "" + a[0];
        for (int i = 1; i < a.length; i++) {
            u += " " + toProperWord(a[i]);
        }
        return u;
    }
}
