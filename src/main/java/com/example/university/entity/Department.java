package com.example.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Objects;
import java.util.Set;

@Entity
public class Department {

    private String name;
    private String location;
    @Id
    @GeneratedValue
    private int Id;
    @OneToMany(mappedBy = "department")
    private Set<Employ> employ;

    public Department() {

    }

    public Department(String name, String location, int departmentId) {
        this.name = name;
        this.location = location;
        this.Id = departmentId;
    }

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public int getId() {

        return Id;
    }

    public void setId(int id) {

        this.Id = id;
    }


    public Set<Employ> getEmployes() {

        return this.employ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Id == that.Id && Objects.equals(name, that.name) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, Id);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", Id=" + Id +
                '}';
    }
}
