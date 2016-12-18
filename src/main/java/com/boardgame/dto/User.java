package com.boardgame.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	public String _id;
	
	public String name;
	
	public User(){
		this.name = "default name";
	}
	
	public User(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return String.format("User[id=%s, name='%s']", _id, name);
	}
}