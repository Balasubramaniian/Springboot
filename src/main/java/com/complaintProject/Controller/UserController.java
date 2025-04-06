package com.complaintProject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody User particularuser){
		
		Optional<User> user= repo.findById(id);
		
		User u=user.get();
		u.setName(particularuser.getName());
		
		return ResponseEntity.ok(u);
				
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
	    Optional<User> user = repo.findById(id);
	    
	    if (user.isPresent()) {
	        repo.deleteById(id);
	        return ResponseEntity.ok("User deleted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    }
}

	
}
