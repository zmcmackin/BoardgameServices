package com.boardgame.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.bo.board.Board;
import com.boardgame.bo.board.Tile;
import com.boardgame.dto.Game;
import com.boardgame.enums.GameObjectTypes;
import com.boardgame.enums.board.TokenType;
import com.boardgame.service.GameService;

@Service
public class BoardService {

	@Autowired
	private GameService gameService;

	@Autowired
	private LevelService levelService;

	

	public Board getBoard(String name) {

		Game game = gameService.getGameByName(name);

		game.gameObjects.putIfAbsent(GameObjectTypes.board, new Board());

		Board board = (Board) game.gameObjects.get(GameObjectTypes.board);

		Tile tile = levelService.getTile(board, 0, 0, 0);

		

		gameService.save(game);

		return board;
	}
}
