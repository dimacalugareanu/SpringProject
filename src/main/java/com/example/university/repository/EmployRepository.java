package com.example.university.repository;

import com.example.university.entity.Employ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends CrudRepository<Employ, Integer> {

}
