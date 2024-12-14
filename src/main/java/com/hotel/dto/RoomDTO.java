package com.hotel.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RoomDTO {
    private String roomNumber;
    private String type;
    private BigDecimal price;
    private Integer capacity;
    private String description;
    private String amenities;
    private String imageUrl;
} 