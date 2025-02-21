package com.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600) 
@RestController
@RequestMapping("/api")  // Added base URL to avoid duplicate paths
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    // GET: Fetch all employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // GET: Fetch employee by ID
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    // POST: Create new employee
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    	 if (employee.getName() == null || employee.getManager() == null || employee.getSalary() == null) {
             return ResponseEntity.badRequest().body(null); // Return 400 Bad Request if null values exist
         }
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    // PATCH: Update existing employee
    @PatchMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employeeUpdates) {
        Employee existingEmployee = employeeService.getEmployeeById(employeeId); // Fetch the existing record

        if (existingEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        // ✅ Only update non-null values
        if (employeeUpdates.getName() != null) {
            existingEmployee.setName(employeeUpdates.getName());
        }
        if (employeeUpdates.getManager() != null) {
            existingEmployee.setManager(employeeUpdates.getManager());
        }
        if (employeeUpdates.getSalary() != null) {
            existingEmployee.setSalary(employeeUpdates.getSalary());
        }

        // ✅ Save the updated employee
        Employee updatedEmployee = employeeService.updateEmployee(existingEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // DELETE: Remove employee
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        Employee empObj = employeeService.getEmployeeById(employeeId);
        if (empObj != null) {
            String deleteMsg = employeeService.deleteEmployee(empObj);
            return ResponseEntity.ok(deleteMsg);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
