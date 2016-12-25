package com.boardgame.enums;

import com.boardgame.bo.GameObject;
import com.boardgame.bo.board.Board;

public enum GameObjectTypes {
	board(Board.class), // intentionally breaking the rules for json object display =)
	card(null),
	inventory(null);
	
	Class<? extends GameObject> type;
	
	GameObjectTypes(Class<? extends GameObject> type){
		this.type = type;
	}

	public Class<? extends GameObject> getType() {
		return type;
	}
}
