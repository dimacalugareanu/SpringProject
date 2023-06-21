package com.example.university.services;

import com.example.university.entity.Department;
import com.example.university.entity.Employ;
import com.example.university.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployService {
    @Autowired
    EmployRepository employRepository;
    @Autowired
    DepartmentService departmentService;

    @Transactional
    public Employ getEmployById(int id) {
        return employRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Employ> getListEmploy() {
        List<Employ> employsList = new ArrayList<>();
        Iterable<Employ> employIterable = employRepository.findAll();
        for (Employ employ : employIterable) {
            employsList.add(employ);
        }
        return employsList;

    }

    @Transactional
    public void updateEmploy(int id, Employ employ) {
        Optional<Employ> optional = employRepository.findById(id);
        if (optional.isPresent()) {
            Employ employFromDataBase = optional.get();
            Department department = departmentService.getDepartment(employ.getDepartment().getId());
            employFromDataBase.setDepartment(department);
            employFromDataBase.setFirstName(employ.getFirstName());
            employFromDataBase.setLastName(employ.getLastName());
            employFromDataBase.setEmail(employ.getEmail());
            employFromDataBase.setPhoneNumber(employ.getPhoneNumber());
            employFromDataBase.setSalary(employ.getSalary());
            employRepository.save(employFromDataBase);
        }

    }

    @Transactional
    public void deleteEmploy(int id) {
        Optional<Employ> optional = employRepository.findById(id);
        optional.ifPresent(employ -> employRepository.delete(employ));
    }

    @Transactional
    public void addEmploy(Employ employ) {
        Department department = departmentService.getDepartment(employ.getDepartment().getId());
        employ.setDepartment(department);
        employRepository.save(employ);
    }
}
