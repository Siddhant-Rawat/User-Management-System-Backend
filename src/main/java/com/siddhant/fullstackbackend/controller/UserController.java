package com.siddhant.fullstackbackend.controller;

import com.siddhant.fullstackbackend.exception.UserNotFoundException;
import com.siddhant.fullstackbackend.model.User;
import com.siddhant.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}

	@GetMapping("/users")
	List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	User getUserWithId(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));
	}

//	Edit the user
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		return userRepository.findById(id)
				.map(user -> {
					user.setUserName(newUser.getUserName());
					user.setEmail(newUser.getEmail());
					user.setName(newUser.getName());
					return userRepository.save(user);
				})
				.orElseThrow(() -> new UserNotFoundException(id));
	}

	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Long id) {
		if(!userRepository.existsById(id))
			throw new UserNotFoundException(id);

		userRepository.deleteById(id);
		return "User with id " + id + " has been successfully deleted";
	}
}
