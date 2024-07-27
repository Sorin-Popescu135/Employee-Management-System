package com.example.demo.employee.commandhandlers;

import com.example.demo.Command;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.model.Employee;
import com.example.demo.employee.model.UpdateEmployeeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployeeCommandHandler implements Command<UpdateEmployeeCommand, ResponseEntity> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity execute(UpdateEmployeeCommand command) {
        Employee employee = command.getEmployee();
        employee.setId(command.getId());
        employeeRepository.save(employee);
        return ResponseEntity.ok().build();
    }
}
