package com.stackInstance.RestTemplate.Service;

import com.stackInstance.RestTemplate.Model.Employee;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();
    private static final String get_All_Employee_URL = "http://localhost:2121/stackinstance/getAllEmployee";
    private static final String Create_Employee_URL = "http://localhost:2121/stackinstance/addEmployee";
    private static final String Get_Employee_ById_URL = "http://localhost:2121/stackinstance/getEmployee/{id}";
    private static final String Update_Employee_ById_URL = "http://localhost:2121/stackinstance/updateEmployee";
    private static final String Delete_Employee_ById_URL = "http://localhost:2121/stackinstance/deleteEmployee/{id}";



    //method to get all employee
    /*if the API being consumed requires additional headers or specific configurations,
    such as authentication tokens or custom headers, then use below*/
    public ResponseEntity<String> allEmployee(){
        HttpHeaders headers = new HttpHeaders();  // to represent HTTP request and response headers.
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));  /*This line sets the Accept header in the HTTP request to specify that the client expects a response in JSON format.
                                                                         It ensures that the server understands that the client can handle JSON data.*/

        //headers.add("Authorization", headerValue)
        HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
        ResponseEntity<String> response = restTemplate.exchange(get_All_Employee_URL, HttpMethod.GET,entity, String.class);
        return response;
    }

    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return restTemplate.postForEntity(Create_Employee_URL,employee, Employee.class);
    }

    public Employee getEmployeeById(int id) {
        Map<String,Integer> param = new HashMap<String,Integer>();
        param.put("id",id);
        return restTemplate.getForObject(Get_Employee_ById_URL, Employee.class,param);
    }

    public void updateEmployee(Employee employee) {
        restTemplate.put(Update_Employee_ById_URL,employee);
    }

    public void deleteEmployee(int id) {
        Map<String,Integer> param = new HashMap<String,Integer>();
        param.put("id",id);
        restTemplate.delete(Delete_Employee_ById_URL,param);
    }
}
