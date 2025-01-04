package com.dilemmawalker.yash.dao;

import com.dilemmawalker.yash.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
