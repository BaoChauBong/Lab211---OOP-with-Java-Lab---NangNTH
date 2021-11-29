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
public class Employee {
    public String id;
    public String firstName;
    public String lastName;
    public String Phone;
    public String Email;
    public String Address;
    public String DOB;
    public String Sex;
    public int Salary;
    public String Egency;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String Phone, String Email, String Address, String DOB, String sex, int Salary, String Egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.DOB = DOB;
        this.Sex = sex;
        this.Salary = Salary;
        this.Egency = Egency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        this.Sex = sex;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public String getEgency() {
        return Egency;
    }

    public void setEgency(String Egency) {
        this.Egency = Egency;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-15s%-10s%-10d%-10s",id,firstName,lastName,
        Phone,Email,Address,DOB,Sex,Salary,Egency);
    }
    
    
}
