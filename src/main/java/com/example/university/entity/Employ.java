package com.example.university.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Employ {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int salary;

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    public Employ() {

    }

    public Employ(String firstName, String lastName, String email, String phoneNumber, int salary, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
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


    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {

        return salary;
    }

    public void setSalary(int salary) {

        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return salary == employ.salary && id == employ.id && Objects.equals(firstName, employ.firstName) && Objects.equals(lastName, employ.lastName) && Objects.equals(email, employ.email) && Objects.equals(phoneNumber, employ.phoneNumber) && Objects.equals(department, employ.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber, salary, id, department);
    }

    @Override
    public String toString() {
        return "Employ{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                ", department=" + department +
                '}';
    }
}
