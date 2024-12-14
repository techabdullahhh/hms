package com.hotel.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long customerId;
    private Long roomId;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private Integer numberOfGuests;
    private String specialRequests;
} 