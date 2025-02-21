package com.employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "employee", schema = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid")
    private Long employeeId;

    @JsonProperty("name") // Ensure JSON correctly maps to this field
    @Column(name = "name", nullable = false)
    private String name;

    @JsonProperty("manager")
    @Column(name = "manager", nullable = false)
    private String manager;

    @JsonProperty("salary")
    @Column(name = "salary", nullable = false)
    private Integer salary;

    // ✅ Add Manual Constructor
    public Employee() {}

    public Employee(String name, String manager, Integer salary) {
        this.name = name;
        this.manager = manager;
        this.salary = salary;
    }

    // ✅ Add Manual Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getManager() { return manager; }
    public void setManager(String manager) { this.manager = manager; }

    public Integer getSalary() { return salary; }
    public void setSalary(Integer salary) { this.salary = salary; }

    // ✅ Fix Logging Issue
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", salary=" + salary +
                '}';
    }
}
