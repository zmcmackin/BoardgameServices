package com.boardgame.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boardgame.dto.Game;

public interface GameRepository extends MongoRepository<Game, String> {
	public Game findByName(String name);
}

