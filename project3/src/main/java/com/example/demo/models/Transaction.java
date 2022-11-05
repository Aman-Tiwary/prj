package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "TransactionDetail")
public class Transaction {
    @Id
    private String shareId;
    private String assetId;
    private String assignedTo;
    private boolean transactionType;


    public Transaction (String shareId,String assetId,String assignedTo,boolean transactionType)
    {
        this.shareId=shareId;
        this.assetId=assetId;
        this.assignedTo=assignedTo;
        this.transactionType=transactionType;
    }

    
}
