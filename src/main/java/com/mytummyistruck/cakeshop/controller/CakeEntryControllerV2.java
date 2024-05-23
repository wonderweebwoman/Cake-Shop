package com.mytummyistruck.cakeshop.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytummyistruck.cakeshop.entity.CakeEntry;
import com.mytummyistruck.cakeshop.entity.Customer;
import com.mytummyistruck.cakeshop.service.CakeEntryService;
import com.mytummyistruck.cakeshop.service.CustomerService;

@RestController
@RequestMapping("cakeshop")
public class CakeEntryControllerV2 {

    @Autowired
    private CakeEntryService cakeEntryService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/{username}")
    public ResponseEntity<?> addOrder(@PathVariable String username, @RequestBody CakeEntry newEntry){
        try{
            cakeEntryService.addOrder(username, newEntry);
            return new ResponseEntity<>("Order placed!", HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>("Oops! There has been an error.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getOrdersOfCustomer(@PathVariable String username){
        Customer customer = customerService.searchCustomer(username);
        if(customer!=null){
            List<CakeEntry> entries = customer.getOrders();
            if(entries!=null && !entries.isEmpty())
                return new ResponseEntity<>(entries, HttpStatus.OK);
            return new ResponseEntity<>("Customer has no active orders.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Username does not exist.", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{username}/{myId}")
    public ResponseEntity<?> updateOrder(@PathVariable String username, @PathVariable ObjectId myId, @RequestBody CakeEntry newEntry){
        CakeEntry oldEntry = cakeEntryService.findOrderById(myId).orElse(null);
        if(oldEntry!=null){
            oldEntry.setFlavour(newEntry.getFlavour()!=null && !newEntry.getFlavour().equals("") ? newEntry.getFlavour() : oldEntry.getFlavour());
            oldEntry.setType(newEntry.getType()!=null && !newEntry.getType().equals("") ? newEntry.getType() : oldEntry.getType());
            oldEntry.setPrice(newEntry.getPrice()>0 ? newEntry.getPrice() : oldEntry.getPrice());
            cakeEntryService.addOrder(oldEntry);
            return new ResponseEntity<>("Order updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Order does not exist.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{username}/{myId}")
    public ResponseEntity<?> deleteOrder(@PathVariable String username, @PathVariable ObjectId myId){
        cakeEntryService.deleteOrder(username, myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
