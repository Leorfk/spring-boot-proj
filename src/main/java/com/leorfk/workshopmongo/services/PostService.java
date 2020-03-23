package com.leorfk.workshopmongo.services;

import com.leorfk.workshopmongo.domain.Post;
import com.leorfk.workshopmongo.dto.UserDTO;
import com.leorfk.workshopmongo.repository.PostRepository;
import com.leorfk.workshopmongo.repository.UserRepository;
import com.leorfk.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;

	public Post findById(String id) {
		Optional<Post> obj = postRepo.findById(id);
		// retorna um objeto ou lança uma exception
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text){
		return postRepo.findByTitleContainingIgnoreCase(text);
	}

	public List<Post> findByTitleQuery(String text){
		return postRepo.searchTitle(text);
	}
}
