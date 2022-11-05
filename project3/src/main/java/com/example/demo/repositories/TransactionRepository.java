package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction,String>{

    
}
