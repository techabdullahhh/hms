package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hotel.dto.CustomerRegistrationDTO;
import com.hotel.dto.LoginDTO;
import com.hotel.model.Customer;
import com.hotel.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerRegistrationDTO registrationDTO) {
        try {
            Customer customer = customerService.registerCustomer(registrationDTO);
            return ResponseEntity.ok(customer);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginDTO loginDTO) {
        try {
            Customer customer = customerService.loginCustomer(loginDTO);
            return ResponseEntity.ok(customer);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
} 