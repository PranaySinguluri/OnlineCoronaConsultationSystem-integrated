package com.coronaconsultation.services;

import com.coronaconsultation.entities.Room;

public interface IRoomService {
		
		public boolean createRoom(Room room) ;
		
		public boolean updateRoom(Room room);
		
		public Room findById(int id);

	}


