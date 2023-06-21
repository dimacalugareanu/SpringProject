package com.example.university;

import com.example.university.entity.Department;
import com.example.university.entity.Employ;
import com.example.university.services.EmployService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class EmployeeRepositoryTests extends Assertions {
    @Autowired
    EmployService employService;
    Department department = new Department("Production", "Bucharest", 2);
    Employ employ = new Employ("Dima", "Calugareanu", "calugareanu@gmail.com", "062007532", 8000, department);

    @Test
    @Order(1)
    public void addEmployTest(){

        employService.addEmploy(employ);
        assertThat(employ.getId()).isGreaterThan(0);
        assertThat(employ.getDepartment().getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getEmployTest(){

        Employ employ2 = employService.getEmployById(employ.getId());
        assertThat(employ2.getId()).isEqualTo(employ.getId());

    }
    @Test
    @Order(3)
    public void updateEmployTest(){

        Employ employUpdate = new Employ("Dima", "Calugareanu", "calugareanudima@gmail.com", "062007532", 8000, department);
        employService.updateEmploy(employ.getId(), employUpdate);
        assertThat(employService.getEmployById(employ.getId()).getEmail()).isEqualTo("calugareanudima@gmail.com");

    }
    @Test
    @Order(4)
    public void deleteEmployTest(){

        employService.deleteEmploy(1);
        assertThat(employService.getEmployById(1)).isEqualTo(null);

    }


}
