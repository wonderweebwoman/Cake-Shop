package com.mytummyistruck.cakeshop.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mytummyistruck.cakeshop.entity.CakeEntry;
import com.mytummyistruck.cakeshop.entity.Customer;
import com.mytummyistruck.cakeshop.repository.CakeShopRepository;

@Component
public class CakeEntryService {
    
    @Autowired
    private CakeShopRepository cakeShopRepository;
    @Autowired
    private CustomerService customerService;

    //overloaded function
    public void addOrder(CakeEntry myEntry){
        cakeShopRepository.save(myEntry);
    }

    @Transactional
    public void addOrder(String username, CakeEntry newEntry){
        Customer customer = customerService.searchCustomer(username);
        if(customer!=null){
            cakeShopRepository.save(newEntry);
            customer.getOrders().add(newEntry);
            // customer.setUsername(null);
            customerService.addCustomer(customer);
        }
        else{
            //ask to create customer first
        }
    }

    public Optional<CakeEntry> findOrderById(ObjectId myId){
        return cakeShopRepository.findById(myId);
    }

    public void deleteOrder(String username, ObjectId myId){
        Customer customer = customerService.searchCustomer(username);
        customer.getOrders().removeIf(x -> x.getId().equals(myId));  //lambda function
        customerService.addCustomer(customer);
        cakeShopRepository.deleteById(myId);
    }

}
