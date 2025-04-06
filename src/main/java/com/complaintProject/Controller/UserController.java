package com.complaintProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complaintProject.Model.User;
import com.complaintProject.repo.UserRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	
	@GetMapping("/get")
	public ResponseEntity<List<User>> getUsers(){
		
		List<User> users= repo.findAll();
		return ResponseEntity.ok(users);
	}
	
	@PostMapping("/create")
	@Transactional
	public ResponseEntity<User> createUser( @RequestBody User user){
		User u=repo.save(user);
		return ResponseEntity.ok(u);
	}

	
}
