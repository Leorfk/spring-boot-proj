package com.leorfk.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.leorfk.workshopmongo.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leorfk.workshopmongo.domain.User;
import com.leorfk.workshopmongo.dto.UserDTO;
import com.leorfk.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService userServ;
	
	@RequestMapping(method=RequestMethod.GET)// @GetMapping -> faz a mesma função da nottation @RequestMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userServ.findAll();
		// Utilizamos o stream() apenas para que possamos utilizar o metodo map para realizarmos a conversao de cada obj em um objDTO
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = userServ.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
		User obj = userServ.fromDTO(objDTO);
		obj = userServ.insert(obj);
		// Essa variável serve como configuração de retorno com o código de resposta 201
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id){
		userServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id){
		User obj = userServ.fromDTO(objDTO);
		obj.setId(id);
		obj = userServ.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="{id}/posts", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User obj = userServ.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
}
