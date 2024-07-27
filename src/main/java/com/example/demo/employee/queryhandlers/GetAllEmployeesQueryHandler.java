package com.example.demo.employee.queryhandlers;

import com.example.demo.Query;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEmployeesQueryHandler implements Query<Void, List<Employee>> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<List<Employee>> execute(Void input) {
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}
