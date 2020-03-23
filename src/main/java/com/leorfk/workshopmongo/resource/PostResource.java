package com.leorfk.workshopmongo.resource;

import com.leorfk.workshopmongo.domain.Post;
import com.leorfk.workshopmongo.domain.User;
import com.leorfk.workshopmongo.dto.UserDTO;
import com.leorfk.workshopmongo.resource.util.URL;
import com.leorfk.workshopmongo.services.PostService;
import com.leorfk.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService postServ;

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = postServ.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){

		text = URL.decodeParam(text);
		List<Post> list = postServ.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
