package com.mytummyistruck.cakeshop.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("cakeshop_items")
public class CakeEntry {
    
    @Id
    private ObjectId id;
    private String flavour;
    private String type;
    private int price;
}
