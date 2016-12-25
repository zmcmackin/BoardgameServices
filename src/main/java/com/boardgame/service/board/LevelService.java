package com.boardgame.service.board;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.bo.board.Board;
import com.boardgame.bo.board.Connection;
import com.boardgame.bo.board.Level;
import com.boardgame.bo.board.Tile;

@Service
public class LevelService {

	@Autowired
	private TokenService tokenService;
	
	public Tile getTile(Board board, Level level, int x, int y) {
		level.getTiles().putIfAbsent(x, new HashMap<>());
		level.getTiles().get(x).put(y, buildTile(board, level));

		return level.getTiles().get(x).get(y);
	}

	private Tile buildTile(Board board, Level level) {
		Tile tile = new Tile();

		if(board.getTokens().isEmpty()){
			tokenService.createStartToken(board, tile);
		}
		
		return tile;
	}

	public Level getLevel(Board board, int level) {
		board.getLevels().putIfAbsent(level, new Level());

		return board.getLevels().get(level);
	}

	public Tile getTile(Board board, int level, int x, int y) {
		Tile tile = getTile(board, getLevel(board, level), x, y);

		return tile;
	}

	public Connection getConnection(Tile from, int toLevel, int toX, int toY) {
		Connection toConn = new Connection(toLevel, toX, toY);

		for (Connection tConn : from.getConnections()) {
			if (toConn.equals(tConn)) {
				toConn = tConn;
				break;
			}
		}

		return toConn;
	}
}
