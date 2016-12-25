package com.boardgame.bo.board;

import com.boardgame.enums.board.TokenType;

public class Token {

	String name;
	
	TokenType type;
	
	Object owner;

	public Token() {
		this.type = TokenType.GLOBAL;
	}

	public Token(String name, TokenType type, Object owner) {
		super();
		this.name = name;
		this.type = type;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public Object getOwner() {
		return owner;
	}

	public TokenType getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Object owner) {
		this.owner = owner;
	}

	public void setType(TokenType type) {
		this.type = type;
	}
}
