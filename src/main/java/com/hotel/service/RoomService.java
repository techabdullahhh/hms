package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.model.Room;
import com.hotel.dto.RoomDTO;
import com.hotel.repository.RoomRepository;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setType(roomDTO.getType());
        room.setPrice(roomDTO.getPrice());
        room.setCapacity(roomDTO.getCapacity());
        room.setDescription(roomDTO.getDescription());
        room.setAmenities(roomDTO.getAmenities());
        room.setImageUrl(roomDTO.getImageUrl());
        room.setStatus("AVAILABLE");
        
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByStatus("AVAILABLE");
    }

    public Room updateRoom(Long id, RoomDTO roomDTO) {
        Room room = roomRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Room not found"));
            
        room.setType(roomDTO.getType());
        room.setPrice(roomDTO.getPrice());
        room.setCapacity(roomDTO.getCapacity());
        room.setDescription(roomDTO.getDescription());
        room.setAmenities(roomDTO.getAmenities());
        room.setImageUrl(roomDTO.getImageUrl());
        
        return roomRepository.save(room);
    }
} 