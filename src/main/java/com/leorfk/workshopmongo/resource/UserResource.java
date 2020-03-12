package com.leorfk.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import com.leorfk.workshopmongo.services.UserService;

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
	
}
