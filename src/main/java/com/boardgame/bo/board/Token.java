package com.boardgame.bo.board;

import com.boardgame.bo.GameObjectWithTraits;
import com.boardgame.enums.board.TokenType;

public class Token extends GameObjectWithTraits {

    String name;

    String type;

    Object owner;

    public Token() {
        this.type = TokenType.GLOBAL.toString();
    }

    public Token(String name, String type, Object owner) {
        this.name = name;
        this.type = type;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }
}
