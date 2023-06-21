package com.example.university.mapper;

import com.example.university.dto.DepartmentDto;
import com.example.university.entity.Department;
import com.example.university.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentMapper {
    @Autowired
    DepartmentRepository departmentRepository;

    public DepartmentDto getDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName(department.getName());
        departmentDto.setLocation(department.getLocation());
        return departmentDto;
    }

    public List<DepartmentDto> getDepartmentDtoList(List<Department> departments) {
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        Iterable<Department> departmentIterable = departmentRepository.findAll();
        for (Department departmentDB : departmentIterable) {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setName(departmentDB.getName());
            departmentDto.setLocation(departmentDB.getLocation());
            departmentDtoList.add(departmentDto);
        }
        return departmentDtoList;
    }


}
