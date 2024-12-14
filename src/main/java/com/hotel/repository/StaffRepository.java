package com.hotel.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Staff> findByStaffId(String staffId);
} 