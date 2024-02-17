package com.stackInstance.RestTemplate.Controller;

import com.stackInstance.RestTemplate.Model.Employee;
import com.stackInstance.RestTemplate.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stackinstance")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/getAllEmployee")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }
    @GetMapping("/getEmployee/{employeeId}")
    public Optional<Employee> getEmployeebyId(@PathVariable int employeeId){
        return employeeService.getEmployee(employeeId);
    }
    @PutMapping("/updateEmployee")
    public Employee updateEmployeeById(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public void deleteEmployeeById(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
    }


}
