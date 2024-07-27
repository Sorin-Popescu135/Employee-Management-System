package com.example.demo.task.model;

import com.example.demo.employee.model.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private LocalDate deadline;
    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
