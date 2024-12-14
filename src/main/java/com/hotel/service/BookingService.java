package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.model.Booking;
import com.hotel.model.Room;
import com.hotel.model.Customer;
import com.hotel.dto.BookingDTO;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.CustomerRepository;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    public Booking createBooking(BookingDTO bookingDTO) {
        Room room = roomRepository.findById(bookingDTO.getRoomId())
            .orElseThrow(() -> new RuntimeException("Room not found"));
            
        Customer customer = customerRepository.findById(bookingDTO.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));
            
        if (!"AVAILABLE".equals(room.getStatus())) {
            throw new RuntimeException("Room is not available");
        }

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setCheckInDate(bookingDTO.getCheckInDate());
        booking.setCheckOutDate(bookingDTO.getCheckOutDate());
        booking.setNumberOfGuests(bookingDTO.getNumberOfGuests());
        booking.setSpecialRequests(bookingDTO.getSpecialRequests());
        booking.setStatus("PENDING");
        
        room.setStatus("OCCUPIED");
        roomRepository.save(room);
        
        return bookingRepository.save(booking);
    }

    public List<Booking> getCustomerBookings(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    public Booking updateBookingStatus(Long bookingId, String status) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
            
        booking.setStatus(status);
        
        if ("CANCELLED".equals(status)) {
            Room room = booking.getRoom();
            room.setStatus("AVAILABLE");
            roomRepository.save(room);
        }
        
        return bookingRepository.save(booking);
    }
} 