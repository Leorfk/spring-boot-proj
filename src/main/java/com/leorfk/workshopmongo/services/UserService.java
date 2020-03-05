package com.leorfk.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leorfk.workshopmongo.domain.User;
import com.leorfk.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public List<User> findAll(){
		return userRepo.findAll();
	}
}
