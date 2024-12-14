package com.hotel.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private String status; 
    private BigDecimal totalAmount;
    private Integer numberOfGuests;
    private String specialRequests;
    
    @Column(name = "booking_date")
    private LocalDateTime bookingDate = LocalDateTime.now();
} 