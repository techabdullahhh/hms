package com.hotel.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Admin> findByAdminCode(String adminCode);
} 