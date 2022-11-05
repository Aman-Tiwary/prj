package com.example.demo.models;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "AssetDetails")
public class AssetDetails implements Serializable{
    @Indexed(unique = true)
    private String assetId;
    private String assetName;
    private String assetCategory;
    private boolean assetType;
    private String assignedTo;
    private boolean isAvailable;


    public AssetDetails (String assetId,String assetName,String assetCategory,boolean assetType,String assignedTo,boolean isAvailable)
    {
        this.assetId=assetId;
        this.assetName=assetName;
        this.assetCategory=assetCategory;
        this.assetType=assetType;
        this.assignedTo=assignedTo;
        this.isAvailable=isAvailable;
    }
    
}
