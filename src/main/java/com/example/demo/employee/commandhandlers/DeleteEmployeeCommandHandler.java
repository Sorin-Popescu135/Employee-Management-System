package com.example.demo.employee.commandhandlers;

import com.example.demo.Command;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployeeCommandHandler implements Command<Integer, ResponseEntity> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(Integer id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
