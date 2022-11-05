package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.AssetDetails;;

@Repository
public interface AssetDetailsRepository extends MongoRepository<AssetDetails,String>{

    List<AssetDetails> findByAssignedTo(String employeeId);

    AssetDetails findByAssetId(String assetId);

}
