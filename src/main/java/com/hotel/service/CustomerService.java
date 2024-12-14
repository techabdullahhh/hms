package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hotel.dto.CustomerRegistrationDTO;
import com.hotel.dto.LoginDTO;
import com.hotel.model.Customer;
import com.hotel.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Customer registerCustomer(CustomerRegistrationDTO registrationDTO) {
        if (customerRepository.existsByEmail(registrationDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Customer customer = new Customer();
        customer.setFirstName(registrationDTO.getFirstName());
        customer.setLastName(registrationDTO.getLastName());
        customer.setEmail(registrationDTO.getEmail());
        customer.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        customer.setPhone(registrationDTO.getPhone());

        return customerRepository.save(customer);
    }

    public Customer loginCustomer(LoginDTO loginDTO) {
        Customer customer = customerRepository.findByEmail(loginDTO.getEmail())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), customer.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return customer;
    }
} 