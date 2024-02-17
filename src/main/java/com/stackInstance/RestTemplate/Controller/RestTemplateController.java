package com.stackInstance.RestTemplate.Controller;

import com.stackInstance.RestTemplate.Model.Employee;
import com.stackInstance.RestTemplate.Service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {
    @Autowired
    private RestTemplateService restTemplateService;


    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return restTemplateService.createEmployee(employee);
    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<String> getAllEmployee(){
        return restTemplateService.allEmployee();
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return restTemplateService.getEmployeeById(id);
    }
    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        restTemplateService.updateEmployee(employee);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable int id){
        restTemplateService.deleteEmployee(id);
    }
}
