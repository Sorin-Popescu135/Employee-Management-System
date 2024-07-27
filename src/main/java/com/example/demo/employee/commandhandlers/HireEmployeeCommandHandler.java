package com.example.demo.employee.commandhandlers;

import com.example.demo.Command;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.model.Employee;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HireEmployeeCommandHandler implements Command<Employee, ResponseEntity> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity execute(Employee employee) {

        validateEmployee(employee);

        employeeRepository.save(employee);
        return ResponseEntity.ok().build();
    }



    private void validateEmployee(Employee employee) {
        if(StringUtils.isBlank(employee.getName())) {
            throw new RuntimeException("Exployee name is not correct.");
        }

        if(employee.getAge() < 18) {
            throw new RuntimeException("Employee cannot be under 18 years old.");
        }

        if(employee.getSalary() <= 0.0) {
            throw new RuntimeException("Salary cannot be negative.");
        }
    }
}
