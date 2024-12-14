package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.model.Room;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByStatus(String status);
    List<Room> findByTypeAndStatus(String type, String status);
} 