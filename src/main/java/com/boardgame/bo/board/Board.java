package com.boardgame.bo.board;

import java.util.HashMap;
import java.util.Map;

import com.boardgame.bo.GameObject;

public class Board extends GameObject {
	protected Map<Integer, Level> levels = new HashMap<>();
	
	protected Map<String, Token> tokens = new HashMap<>();
	

	public Map<Integer, Level> getLevels() {
		return levels;
	}

	public Map<String, Token> getTokens() {
		return tokens;
	}

	public void setLevels(Map<Integer, Level> levels) {
		this.levels = levels;
	}

	public void setTokens(Map<String, Token> tokens) {
		this.tokens = tokens;
	}
}