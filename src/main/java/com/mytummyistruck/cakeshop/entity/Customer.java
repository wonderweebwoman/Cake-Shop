package com.mytummyistruck.cakeshop.entity;

import java.util.ArrayList;
import java.util.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import lombok.Data;

@Data
@Document(collection = "customers")
public class Customer {
    
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    @DBRef
    private List<CakeEntry> orders = new ArrayList<>();

}
