package com.boardgame;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/")
	public @ResponseBody String hello(){
		return "{\"text\":\"hello\"}";
	}
	
	@RequestMapping("/users") /* Maps to all HTTP actions by default (GET,POST,..)*/
    public @ResponseBody
    String getUsers() {
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
            "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }

}
