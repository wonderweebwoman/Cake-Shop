package com.mytummyistruck.cakeshop.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mytummyistruck.cakeshop.entity.Customer;

public interface CustomerRespository extends MongoRepository<Customer, ObjectId>{
    Customer findByUsername(String username);
} 
