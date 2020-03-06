package com.leorfk.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
