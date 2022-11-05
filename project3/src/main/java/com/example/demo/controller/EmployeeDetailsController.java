package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.EmployeeDetails;
import com.example.demo.repositories.EmployeeDetailsRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeDetailsController {
    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    @PostMapping("/addMember")
    public ResponseEntity<?> addPersonalAsset( @RequestBody EmployeeDetails employeeDetails)
    {
        employeeDetailsRepository.save(employeeDetails);
        return new ResponseEntity<EmployeeDetails>(HttpStatus.OK);
    }
 
}
