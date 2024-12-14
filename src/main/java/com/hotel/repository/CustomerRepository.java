package com.hotel.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
    boolean existsByEmail(String email);
} 