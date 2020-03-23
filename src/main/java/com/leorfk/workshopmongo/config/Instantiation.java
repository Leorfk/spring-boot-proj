package com.leorfk.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.leorfk.workshopmongo.domain.Post;
import com.leorfk.workshopmongo.dto.AuthorDTO;
import com.leorfk.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leorfk.workshopmongo.domain.User;
import com.leorfk.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		//limpa a coleção no MongoDB
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria da Silva", "maria@receba.com");
		User jose = new User(null, "José da Silva", "jose@toma.com");
		User bob = new User(null, "Bob de Maria José", "bob@marley.com");

		userRepository.saveAll(Arrays.asList(maria, jose, bob));

		Post post1 = new Post(
				null,
				sdf.parse("21/03/2018"),
				"É hora de viajar",
				"Bora pra São Paulo",
				new AuthorDTO(maria));

		Post post2 = new Post(
				null,
				sdf.parse("27/03/2018"),
				"É hora de fazer home",
				"Bora pra casa",
				new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
