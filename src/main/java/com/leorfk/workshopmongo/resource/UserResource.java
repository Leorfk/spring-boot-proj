package com.leorfk.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leorfk.workshopmongo.domain.User;
import com.leorfk.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService userServ;
	
	@RequestMapping(method=RequestMethod.GET)// @GetMapping -> faz a mesma função da nottation @RequestMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = userServ.findAll();
		return ResponseEntity.ok().body(list);
	}
}
