package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hotel.dto.AdminRegistrationDTO;
import com.hotel.dto.LoginDTO;
import com.hotel.model.Admin;
import com.hotel.service.AdminService;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminRegistrationDTO registrationDTO) {
        try {
            Admin admin = adminService.registerAdmin(registrationDTO);
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody LoginDTO loginDTO) {
        try {
            Admin admin = adminService.loginAdmin(loginDTO);
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
} 