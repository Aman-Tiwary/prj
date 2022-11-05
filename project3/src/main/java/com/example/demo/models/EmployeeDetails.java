package com.example.demo.models;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "EmployeeDetails")
public class EmployeeDetails{
    @Indexed(unique = true)
    private String employeeId;
    private String employeeName;



    public EmployeeDetails (String employeeId,String employeeName)
    {
        this.employeeId=employeeId;
        this.employeeName=employeeName;
    }
}
