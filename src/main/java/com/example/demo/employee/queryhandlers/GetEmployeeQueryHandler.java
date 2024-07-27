package com.example.demo.employee.queryhandlers;

import com.example.demo.Query;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetEmployeeQueryHandler implements Query<Integer, Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<Employee> execute(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw  new RuntimeException("Employee not found.");
        }

        return  ResponseEntity.ok(employee.get());
    }
}
