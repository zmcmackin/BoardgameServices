package com.boardgame.bo.board;

import java.util.HashMap;
import java.util.Map;

public class Level {

	Map<Integer, Map<Integer, Tile>> tiles = new HashMap<>();

	public Map<Integer, Map<Integer, Tile>> getTiles() {
		return tiles;
	}

	public void setTiles(Map<Integer, Map<Integer, Tile>> tiles) {
		this.tiles = tiles;
	}
}
