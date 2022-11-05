package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AssetDetails;
import com.example.demo.models.EmployeeDetails;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.AssetDetailsRepository;
import com.example.demo.repositories.EmployeeDetailsRepository;
import com.example.demo.repositories.TransactionRepository;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/insertTransactionDetails")
public class TransactionController {
    @Autowired
    private AssetDetailsRepository assetDetailsRepository;
    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private Transaction transaction;

    public Transaction transactionDetail(String assetId,String assignedTo,boolean transactionType)
    {
        transaction.setAssetId(assetId);
        transaction.setAssignedTo(assignedTo);
        transaction.setTransactionType(transactionType);
        return transactionRepository.insert(transaction);
    }

}
