package com.example.demo.employee.model;


import lombok.Data;

@Data
public class UpdateEmployeeCommand {
    private int id;
    private Employee employee;

    public UpdateEmployeeCommand(Integer id, Employee employee) {
        this.employee = employee;
        this.id = id;
    }
}
