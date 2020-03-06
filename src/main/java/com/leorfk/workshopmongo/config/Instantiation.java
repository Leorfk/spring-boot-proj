package com.leorfk.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leorfk.workshopmongo.domain.User;
import com.leorfk.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//limpa a coleção no MongoDB
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria da Silva", "maria@receba.com");
		User jose = new User(null, "José da Silva", "jose@toma.com");
		User bob= new User(null, "Bob de Maria José", "bob@marley.com");
		userRepository.saveAll(Arrays.asList(maria, jose, bob));
	}
}
