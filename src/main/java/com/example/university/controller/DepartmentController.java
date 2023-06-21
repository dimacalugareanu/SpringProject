package com.example.university.controller;

import com.example.university.dto.DepartmentDto;
import com.example.university.dto.EmployDto;
import com.example.university.entity.Department;
import com.example.university.mapper.DepartmentMapper;
import com.example.university.mapper.EmployMapper;
import com.example.university.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    EmployMapper employMapper;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/department/{id}")
    public DepartmentDto getDepartment(@PathVariable int id) {
        return departmentMapper.getDepartmentDto(departmentService.getDepartment(id));
    }

    @GetMapping("/department")
    public List<DepartmentDto> getDepartmentList() {
        return departmentMapper.getDepartmentDtoList(departmentService.getDepartmentList());
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);

    }

    @PutMapping("/department/{id}")
    public void updateDepartment(@PathVariable int id, @RequestBody @Validated Department department) {
        departmentService.updateDepartment(id, department);
    }

    @PostMapping("/department")
    public void addDepartment(@RequestBody @Validated Department department) {
        departmentService.addDepartment(department);
    }

    @GetMapping("/department/{id}/employees")
    public List<EmployDto> getEmploysForDepartment(@PathVariable int id) {
        Department department = departmentService.getDepartment(id);
        return employMapper.map(department.getEmployes());
    }


}

