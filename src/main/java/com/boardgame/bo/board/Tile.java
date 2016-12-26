package com.boardgame.bo.board;

import com.boardgame.bo.GameObjectWithTraits;
import org.springframework.data.annotation.Transient;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Tile extends GameObjectWithTraits {

    String id;

    boolean isValid;

    Set<Connection> connections = new HashSet<>();

    Set<String> tokenIds = new HashSet<>();

    @Transient
    Integer level;

    @Transient
    Integer x;

    @Transient
    Integer y;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Set<Connection> getConnections() {
        return connections;
    }

    public void setConnections(Set<Connection> connections) {
        this.connections = connections;
    }

    public Set<String> getTokenIds() {
        return tokenIds;
    }

    public void setTokenIds(Set<String> tokenIds) {
        this.tokenIds = tokenIds;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
