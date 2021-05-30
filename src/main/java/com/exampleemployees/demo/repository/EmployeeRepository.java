package com.exampleemployees.demo.repository;

import com.exampleemployees.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByOrderByIdAsc();
    List<Employee> findAllByOrderByIdDesc();
}