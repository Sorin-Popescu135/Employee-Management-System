package com.example.demo.employee;

import com.example.demo.employee.commandhandlers.DeleteEmployeeCommandHandler;
import com.example.demo.employee.commandhandlers.HireEmployeeCommandHandler;
import com.example.demo.employee.commandhandlers.UpdateEmployeeCommandHandler;
import com.example.demo.employee.model.Employee;
import com.example.demo.employee.model.UpdateEmployeeCommand;
import com.example.demo.employee.queryhandlers.GetAllEmployeesQueryHandler;
import com.example.demo.employee.queryhandlers.GetEmployeeQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private GetAllEmployeesQueryHandler getAllEmployeesQueryHandler;

    @Autowired
    private GetEmployeeQueryHandler getEmployeeQueryHandler;

    @Autowired
    private HireEmployeeCommandHandler hireEmployeeCommandHandler;

    @Autowired
    private UpdateEmployeeCommandHandler updateEmployeeCommandHandler;

    @Autowired
    private DeleteEmployeeCommandHandler deleteEmployeeCommandHandler;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return getAllEmployeesQueryHandler.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        return getEmployeeQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity hireEmployee(@RequestBody Employee employee) {
        return hireEmployeeCommandHandler.execute(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        UpdateEmployeeCommand command = new UpdateEmployeeCommand(id, employee);
        return updateEmployeeCommandHandler.execute(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deteleEmployee(@PathVariable Integer id) {
        return deleteEmployeeCommandHandler.execute(id);
    }
}
