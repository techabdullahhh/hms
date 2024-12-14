package com.hotel.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "rooms")
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String roomNumber;
    private String type;
    private BigDecimal price;
    private String status; 
    private Integer capacity;
    private String description;
    private String amenities;
    
    @Column(name = "image_url")
    private String imageUrl;
} 