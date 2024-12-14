package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hotel.dto.StaffRegistrationDTO;
import com.hotel.dto.LoginDTO;
import com.hotel.model.Staff;
import com.hotel.repository.StaffRepository;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Staff registerStaff(StaffRegistrationDTO registrationDTO) {
        if (staffRepository.existsByEmail(registrationDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Staff staff = new Staff();
        staff.setName(registrationDTO.getName());
        staff.setEmail(registrationDTO.getEmail());
        staff.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        staff.setStaffId(registrationDTO.getStaffId());
        staff.setDepartment(registrationDTO.getDepartment());

        return staffRepository.save(staff);
    }

    public Staff loginStaff(LoginDTO loginDTO) {
        Staff staff = staffRepository.findByEmail(loginDTO.getEmail())
            .orElseThrow(() -> new RuntimeException("Staff member not found"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), staff.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return staff;
    }
} 