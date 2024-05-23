package com.mytummyistruck.cakeshop.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mytummyistruck.cakeshop.entity.Customer;
import com.mytummyistruck.cakeshop.repository.CustomerRespository;

@Component
public class CustomerService {
    
    @Autowired
    private CustomerRespository customerRespository;

    public List<Customer> getAll(){
        return customerRespository.findAll();
    }

    public Customer searchCustomer(String username){
        return customerRespository.findByUsername(username);
    }

    public void addCustomer(Customer customer){
        customerRespository.save(customer);
    }

    public void deleteCustomer(Customer customer){
        customerRespository.delete(customer);
    }
}
