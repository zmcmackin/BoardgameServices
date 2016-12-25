package com.boardgame.bo.board;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Tile {

	boolean isValid;

	Set<Connection> connections = new HashSet<>();

	Set<String> tokenIds = new HashSet<>();

	public Set<Connection> getConnections() {
		return connections;
	}

	public Set<String> getTokenIds() {
		return tokenIds;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setConnections(Set<Connection> connections) {
		this.connections = connections;
	}

	public void setTokenIds(Set<String> tokenIds) {
		this.tokenIds = tokenIds;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
