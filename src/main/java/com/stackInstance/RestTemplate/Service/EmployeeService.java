package com.stackInstance.RestTemplate.Service;

import com.stackInstance.RestTemplate.Model.Employee;
import com.stackInstance.RestTemplate.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployee(int employeeId){
        return employeeRepository.findById(employeeId);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
