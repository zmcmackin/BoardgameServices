package com.boardgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boardgame.dao.UserRepository;
import com.boardgame.dto.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/")
	public @ResponseBody String hello(){
		return "{\"text\":\"hello\"}";
	}
	
	//TODO: remove after done with intial setup
	@GetMapping("/deleteUsers")
	public @ResponseBody String deleteUsers(){
		userRepo.deleteAll();
		return "delete successful";
	}
	
	@GetMapping("/users") /* Maps to all HTTP actions by default (GET,POST,..)*/
    public @ResponseBody List<User> getUsers() {
        return userRepo.findAll();
    }
	
	@GetMapping("/createUser/{name}")
	public @ResponseBody User createUser(@PathVariable("name") String name){
		return userRepo.save(new User(name));
	}
	
	@PostMapping("/updateUser")
	public @ResponseBody User updateUser(@RequestBody User user){
		return userRepo.save(user);
	}
}