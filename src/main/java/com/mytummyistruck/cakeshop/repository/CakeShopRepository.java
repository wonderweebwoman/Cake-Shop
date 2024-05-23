package com.mytummyistruck.cakeshop.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mytummyistruck.cakeshop.entity.CakeEntry;

public interface CakeShopRepository extends MongoRepository<CakeEntry, ObjectId> {
    
}
