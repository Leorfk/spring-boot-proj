package com.leorfk.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leorfk.workshopmongo.domain.User;
import com.leorfk.workshopmongo.repository.UserRepository;
import com.leorfk.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepo.findById(id);
		// retorna um objeto ou lança uma exception
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
