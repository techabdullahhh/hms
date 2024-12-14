package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hotel.dto.AdminRegistrationDTO;
import com.hotel.dto.LoginDTO;
import com.hotel.model.Admin;
import com.hotel.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin registerAdmin(AdminRegistrationDTO registrationDTO) {
        if (adminRepository.existsByEmail(registrationDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Admin admin = new Admin();
        admin.setName(registrationDTO.getName());
        admin.setEmail(registrationDTO.getEmail());
        admin.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        admin.setAdminCode(registrationDTO.getAdminCode());
        admin.setAccessLevel(registrationDTO.getAccessLevel());

        return adminRepository.save(admin);
    }

    public Admin loginAdmin(LoginDTO loginDTO) {
        Admin admin = adminRepository.findByEmail(loginDTO.getEmail())
            .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), admin.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return admin;
    }
} 