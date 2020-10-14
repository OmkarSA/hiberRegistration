package com.example.hiberRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hiberRegistration.model.User;
import com.example.hiberRegistration.service.UserService;

@RestController
@RequestMapping("/hiber/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/all")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	/*
	 * @GetMapping("/{id}") public User getUser(@PathVariable("id") Integer id) {
	 * return userService.getUser(id); }
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		User user = userService.getUser(id);

		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User userDetails) {
		User user = userService.getUser(id);

		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		if (userDetails.getName() != null)
			user.setName(userDetails.getName());
		if (userDetails.getEmail() != null)
			user.setEmail(userDetails.getEmail());

		userService.addUser(user);

		return ResponseEntity.ok().body(user);

	}

	/*
	 * @DeleteMapping("/remove/{id}") public String removeUser(@PathVariable("id")
	 * Integer id) { return userService.removeUser(id); }
	 */

	@DeleteMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") Integer id) {
		User user = userService.getUser(id);

		if (user == null) {
			return "User not found";
		}
		userService.removeUser(user);
		return "User deleted from database";
	}
}
