package com.coronaconsultation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coronaconsultation.entities.Room;
import com.coronaconsultation.exception.RoomException;
import com.coronaconsultation.services.RoomServiceImpl;

@RestController
@RequestMapping("/api/room/")
public class RoomController {

	@Autowired
	private RoomServiceImpl roomServiceImpl;
	
	@PostMapping("/")
	public boolean createRoom(@RequestBody Room room) {
		
		roomServiceImpl.createRoom(room);
		return true;
	}
	
	@PostMapping("/v1/")
	public ResponseEntity<Boolean> createRoomV1(@RequestBody Room room) {
		
		roomServiceImpl.createRoom(room);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public Room findById(@PathVariable int id) throws RoomException {
		Room room = roomServiceImpl.findById(id);
		return room;
	}
	
	@GetMapping("/v1/{id}")
	public ResponseEntity<Room> findByIdV1(@PathVariable int id) {
		Room room = roomServiceImpl.findById(id);
		
		return new ResponseEntity<Room>(room, HttpStatus.OK);
	}
	
}