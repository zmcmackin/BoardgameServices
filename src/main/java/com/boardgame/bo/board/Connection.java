package com.boardgame.bo.board;

public class Connection {

	int level;
	int x;
	int y;

	double cost;

	public Connection() {
		this.cost = 1.0;
	}

	public Connection(int level, int x, int y) {
		this();
		this.level = level;
		this.x = x;
		this.y = y;
	}

	public Connection(int level, int x, int y, double cost) {
		super();
		this.level = level;
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Connection other = (Connection) obj;
		if (level != other.level)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public double getCost() {
		return cost;
	}

	public int getLevel() {
		return level;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + level;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
