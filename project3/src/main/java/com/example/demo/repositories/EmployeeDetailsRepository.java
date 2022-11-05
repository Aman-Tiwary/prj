package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository extends MongoRepository<EmployeeDetails,String>{

    EmployeeDetails findByEmployeeId(String empId);
    
}
