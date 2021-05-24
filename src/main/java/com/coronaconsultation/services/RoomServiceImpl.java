package com.coronaconsultation.services;

import com.coronaconsultation.entities.Room;
import com.coronaconsultation.exception.RoomException;
import com.coronaconsultation.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import  com.coronaconsultation.repository.RoomRepository;

	@Service
	public class RoomServiceImpl implements IRoomService {
		
		@Autowired
		private RoomRepository roomRepository;

		@Override
		public boolean createRoom(Room room) {
			
			roomRepository.save(room);
			
			return false;
		}

		@Override
		public boolean updateRoom(Room room) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Room findById(int id)  {
			if(!roomRepository.existsById(id)) {
				throw new RoomException("Room Not Found");
			}
			
			Room e =  roomRepository.findById(id).get();
			return e;
		}

	}
