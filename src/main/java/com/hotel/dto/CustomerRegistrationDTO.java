package com.hotel.dto;

import lombok.Data;

@Data
public class CustomerRegistrationDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
} 