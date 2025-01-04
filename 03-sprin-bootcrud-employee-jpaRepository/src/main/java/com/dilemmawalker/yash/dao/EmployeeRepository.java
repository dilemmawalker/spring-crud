package com.dilemmawalker.yash.dao;

import com.dilemmawalker.yash.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // no code needed here, JpaRespository automatically provides basic functions using class & primary key type provided.
    //here it basically provides add, delete, update functionality based on provided input.
}
