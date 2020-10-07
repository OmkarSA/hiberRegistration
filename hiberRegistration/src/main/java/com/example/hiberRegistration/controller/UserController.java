package com.example.hiberRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/all")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		return userService.getUser(id);
	}

	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@DeleteMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") Integer id) {
		return userService.removeUser(id);
	}
}
