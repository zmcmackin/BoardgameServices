package com.boardgame.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Game {
	@Id
	public String _id;
	
	public String name;
	
	public List<String> user_ids;
	
	public Game(){}
	
	public Game(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return String.format("Game[id=%s, name='%s']", _id, name);
	}
	
}
