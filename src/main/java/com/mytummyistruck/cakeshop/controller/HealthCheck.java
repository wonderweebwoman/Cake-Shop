package com.mytummyistruck.cakeshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health-check")
    public ResponseEntity<?> healthcheck(){
        return new ResponseEntity<>("All good so far!",HttpStatus.OK);
    }
}

