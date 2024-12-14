package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hotel.dto.BookingDTO;
import com.hotel.model.Booking;
import com.hotel.service.BookingService;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingDTO bookingDTO) {
        try {
            Booking booking = bookingService.createBooking(bookingDTO);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getCustomerBookings(@PathVariable Long customerId) {
        return ResponseEntity.ok(bookingService.getCustomerBookings(customerId));
    }

    @PutMapping("/{bookingId}/status")
    public ResponseEntity<?> updateBookingStatus(
            @PathVariable Long bookingId,
            @RequestParam String status) {
        try {
            Booking booking = bookingService.updateBookingStatus(bookingId, status);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
} 