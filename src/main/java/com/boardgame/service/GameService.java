package com.boardgame.service;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.dao.GameRepository;
import com.boardgame.dto.Game;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepo;
	
	public Game getGameByName(String name) {
		Game game = gameRepo.findByName(name);

		if (game == null) {
			throw new BadRequestException(String.format("Game name '%s' does not exist.", name));
		}
		
		return game;
	}
	
	public void save(Game game){
		gameRepo.save(game);
	}
}
