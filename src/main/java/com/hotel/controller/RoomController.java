package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hotel.dto.RoomDTO;
import com.hotel.model.Room;
import com.hotel.service.RoomService;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<?> addRoom(@RequestBody RoomDTO roomDTO) {
        try {
            Room room = roomService.addRoom(roomDTO);
            return ResponseEntity.ok(room);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms() {
        return ResponseEntity.ok(roomService.getAvailableRooms());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Long id, @RequestBody RoomDTO roomDTO) {
        try {
            Room room = roomService.updateRoom(id, roomDTO);
            return ResponseEntity.ok(room);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
} 