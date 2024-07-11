package com.mytummyistruck.cakeshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytummyistruck.cakeshop.entity.Customer;
import com.mytummyistruck.cakeshop.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Customer> customers = customerService.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> searchCustomer(@PathVariable String username){
        Customer customer = customerService.searchCustomer(username);
        if(customer!=null)
            return new ResponseEntity<>(customer, HttpStatus.OK);
        return new ResponseEntity<>("Customer record not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        try{
            customerService.addCustomer(customer);
            return new ResponseEntity<>("Customer record added.", HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // @PutMapping("/{username}")
    // public ResponseEntity<?> updateCustomer(@PathVariable String username, @RequestBody Customer new_customer){
    //     Customer customer = customerService.searchCustomer(username);
    //     if(customer!=null){
    //         customer.setUsername(new_customer.getUsername());
    //         customer.setPassword(new_customer.getPassword());
    //         customerService.addCustomer(customer);
    //         return new ResponseEntity<>("Record updated.", HttpStatus.OK);
    //     }
    //     return new ResponseEntity<>("Record not found.", HttpStatus.NOT_FOUND);
    // }

    // @DeleteMapping("/{username}")
    // public ResponseEntity<?> deleteCustomer(@PathVariable String username){
    //     Customer customer = customerService.searchCustomer(username);
    //     if(customer!=null){
    //         customerService.deleteCustomer(customer);
    //         return new ResponseEntity<>("Record deleted.", HttpStatus.OK);
    //     }
    //     return new ResponseEntity<>("Record does not exist.", HttpStatus.NOT_FOUND);
    // }
}
