package com.example.demo.controller;
import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AssetDetails;
import com.example.demo.repositories.AssetDetailsRepository;
import com.example.demo.repositories.EmployeeDetailsRepository;

import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@ToString
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assets")
public class AssetDetailsController {
    @Autowired
    private AssetDetailsRepository assetDetailsRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;
    @Autowired 
    private TransactionController transactionController;
    
    @PostMapping("/addPersonalAsset")
    public ResponseEntity<?> addPersonalAsset( @RequestBody AssetDetails assetDetails)
    {
        Random n = new Random();
        assetDetails.setAssetId("pa"+String.valueOf(n.nextInt()));
        assetDetails.setAssetType(false);
        assetDetails.setAvailable(false);
        assetDetailsRepository.save(assetDetails);
        return new ResponseEntity<AssetDetails>(HttpStatus.OK);
    }
    
    @PostMapping("/addTeamAsset")
    public ResponseEntity<?> addTeamAsset( @RequestBody AssetDetails assetDetails)
    {
        Random n = new Random();
        assetDetails.setAssetId("ta"+String.valueOf(n.nextInt()));
        assetDetails.setAssetType(true);
        assetDetails.setAvailable(true);
        assetDetailsRepository.save(assetDetails);
        return new ResponseEntity<AssetDetails>(HttpStatus.OK);
    }

    @PatchMapping("/addTeamAssetToEmployee/{employeeId}/{assetId}")
    public ResponseEntity<?> addTeamAssetToEmployee(@PathVariable String employeeId,@PathVariable String assetId, @RequestBody AssetDetails assetDetails)
    {
        Query q = new Query();
        q.addCriteria(Criteria.where("assetId").is(assetId).and("isAvailable").is(true));
        AssetDetails asset = mongoTemplate.findOne(q, AssetDetails.class);
        asset.setAssetCategory(assetId);
        assetDetails.setAssetId(assetId);
        assetDetails.setAssetName(assetId);
        transactionController.transactionDetail(assetId, employeeId, false);
        return new ResponseEntity<AssetDetails>(HttpStatus.OK);
    }

    @GetMapping("/getPersonalAssets")
    public List<AssetDetails> getPersonalAsset()
    {
        Query q = new Query();
        q.addCriteria(Criteria.where("assetType").is(false));
        return mongoTemplate.find(q, AssetDetails.class);
    }

    @GetMapping("/getAssetById/{employeeId}/{assetType}")
    public List<AssetDetails> getAssetById(@PathVariable String employeeId,@PathVariable boolean assetType)
    {
        Query q = new Query();
        q.addCriteria(Criteria.where("assetType").is(assetType).and("assignedTo").is(employeeId));
        return mongoTemplate.find(q, AssetDetails.class);
    }

    @GetMapping("/getTeamAssets")
    public List<AssetDetails> getTeamAsset()
    {
        Query q = new Query();
        q.addCriteria(Criteria.where("assetType").is(true));
        return mongoTemplate.find(q, AssetDetails.class);
    }

}
