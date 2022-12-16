package com.javainuse.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		updateUser.setPassword(userDetails.getPassword());
		updateUser.setUsername(userDetails.getUsername());

		userRepository.save(updateUser);

		return ResponseEntity.ok(updateUser);

	}

	

}
