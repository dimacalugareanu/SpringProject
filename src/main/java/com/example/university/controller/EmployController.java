package com.example.university.controller;

import com.example.university.dto.EmployDto;
import com.example.university.mapper.EmployMapper;
import com.example.university.services.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployController {
    @Autowired
    EmployMapper employMapper;
    @Autowired
    EmployService employservice;

    @GetMapping("/employees/{id}")
    public EmployDto getEmployId(@PathVariable int id) {
        return employMapper.map(employservice.getEmployById(id));

    }

    @GetMapping("/employees")
    public List<EmployDto> getEmployList() {
        return employMapper.map(employservice.getListEmploy());
    }

    @PutMapping("/employees/{id}")
    public void updateEmploy(@PathVariable int id, @Validated @RequestBody EmployDto employDto) {
        employservice.updateEmploy(id, employMapper.map(employDto));
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmploy(@PathVariable int id) {
        employservice.deleteEmploy(id);
    }

    @PostMapping(("/employees"))
    public void addEmploy(@RequestBody @Validated EmployDto employDto) {
        employservice.addEmploy(employMapper.map(employDto));
    }

}
