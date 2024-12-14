package com.hotel.dto;

import lombok.Data;

@Data
public class AdminRegistrationDTO {
    private String name;
    private String email;
    private String password;
    private String adminCode;
    private String accessLevel;
} 