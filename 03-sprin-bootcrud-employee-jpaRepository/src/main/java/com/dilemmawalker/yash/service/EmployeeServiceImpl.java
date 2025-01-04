package com.dilemmawalker.yash.service;

import com.dilemmawalker.yash.dao.EmployeeRepository;
import com.dilemmawalker.yash.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        } else {
            throw new RuntimeException("did not find employee id: "+ id);
        }

        return employee;
    }

    @Override
//    @Transactional // we can remove @Transactional as JpaResository automatically provides this capability.
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
//    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
