package com.example.university.mapper;

import com.example.university.dto.EmployDto;
import com.example.university.entity.Department;
import com.example.university.entity.Employ;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployMapper {

    public EmployDto map(Employ employ) {
        EmployDto employDto = new EmployDto();
        employDto.setDepartmentId(employ.getDepartment().getId());
        employDto.setEmail(employ.getEmail());
        employDto.setFirstName(employ.getFirstName());
        employDto.setLastName(employ.getLastName());
        employDto.setPhoneNumber(employ.getPhoneNumber());
        employDto.setSalary(employ.getSalary());
        return employDto;
    }

    public Employ map(EmployDto employDto) {
        Employ employ = new Employ();
        Department department = new Department();
        department.setId(employDto.getDepartmentId());
        employ.setEmail(employDto.getEmail());
        employ.setFirstName(employDto.getFirstName());
        employ.setLastName(employDto.getLastName());
        employ.setPhoneNumber(employDto.getPhoneNumber());
        employ.setSalary(employDto.getSalary());
        employ.setDepartment(department);
        return employ;
    }

    public List<EmployDto> map(Collection<Employ> employs) {
        return employs.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

}
