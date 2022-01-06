package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.models.entities.Employee;
import net.javaguides.springboot.models.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // get employees
    @GetMapping("employees")
    public List<Employee> getAllEmployee(){
        return this.employeeRepository.findAll();
    }
    // get employee by id
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
            return ResponseEntity.ok().body(employee);
        }
    // save employee
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }
    // update employee
    // delete employee
}
