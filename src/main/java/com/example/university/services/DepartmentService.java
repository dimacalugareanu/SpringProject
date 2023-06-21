package com.example.university.services;

import com.example.university.entity.Department;
import com.example.university.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    public Department getDepartment(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Department> getDepartmentList() {
        List<Department> departmentList = new ArrayList<>();
        Iterable<Department> iterable = departmentRepository.findAll();
        for (Department department : iterable) {
            departmentList.add(department);
        }
        return departmentList;
    }

    public void updateDepartment(int id, Department department) {
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isPresent()) {
            Department departmentFromDataBase = optional.get();
            departmentFromDataBase.setName(department.getName());
            departmentFromDataBase.setLocation(department.getLocation());
            departmentRepository.save(departmentFromDataBase);

        }
    }

    @Transactional
    public void deleteDepartment(int id) {
        Optional<Department> optional = departmentRepository.findById(id);
        optional.ifPresent(department -> departmentRepository.delete(department));
    }

    @Transactional
    public void addDepartment(Department department) {

        departmentRepository.save(department);
    }

}
