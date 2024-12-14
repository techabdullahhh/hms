package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hotel.dto.StaffRegistrationDTO;
import com.hotel.dto.LoginDTO;
import com.hotel.model.Staff;
import com.hotel.service.StaffService;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "*")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/register")
    public ResponseEntity<?> registerStaff(@RequestBody StaffRegistrationDTO registrationDTO) {
        try {
            Staff staff = staffService.registerStaff(registrationDTO);
            return ResponseEntity.ok(staff);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginStaff(@RequestBody LoginDTO loginDTO) {
        try {
            Staff staff = staffService.loginStaff(loginDTO);
            return ResponseEntity.ok(staff);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
} 