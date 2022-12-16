package com.javainuse.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.User;
import com.javainuse.repository.UserRepository;
import com.javainuse.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@PostMapping(value = "/save")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllUsers")
	public List<User> getUsers(User user) {
		List<User> users = userService.getUsers();
		return users;
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
		User updateUser = userRepository.findById(id).get();

		updateUser.setDOB(userDetails.getDOB());
		updateUser.setJoiningDate(userDetails.getJoiningDate());
		updateUser.setFirstName(userDetails.getFirstName());
		updateUser.setLastName(userDetails.getLastName());
		updateUser.setPassword(userDetails.getPassword());
		updateUser.setUsername(userDetails.getUsername());

		userRepository.save(updateUser);

		return ResponseEntity.ok(updateUser);

	}

	@PutMapping(value = "/delete/soft/{id}")
	public ResponseEntity<User> softDelete(@PathVariable Integer id) {
		User updateUser = userRepository.findById(id).get();

		updateUser.setDeleted(1);

		userRepository.save(updateUser);

		return ResponseEntity.ok(updateUser);

	}

	@DeleteMapping(value = "/delete/hard/{id}")
	public void hardDelete(@PathVariable Integer id) {
		userRepository.deleteById(id);

	}

	@GetMapping(value = "/searchUsersByFirstNameLastNamePincode")
	public List<User> getUsers(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false, defaultValue = "1") Integer pincode) {
		List<User> users = userRepository.findByFirstNameOrLastNameOrPincode(firstName, lastName, pincode);
		return users;
	}
	
	@GetMapping(value = "/sortByJoiningDate")
	public List<User> sortUsersByJoiningDate(User user){
		
		List<User> users = userService.getUsers();
		Comparator<User> comparator = (u1 ,u2) -> {
			return u1.getJoiningDate().compareTo(u2.getJoiningDate());
		};
		
		Collections.sort(users, comparator);
		
		
		
		return users;
	}
	
	
	@GetMapping(value = "/sortByDOB")
	public List<User> sortUsersByDOB(User user){
		
		List<User> users = userService.getUsers();
		Comparator<User> comparator = (u1 ,u2) -> {
			return u1.getDOB().compareTo(u2.getDOB());
		};
		
		Collections.sort(users, comparator);
		
		
		
		return users;
	}

}
