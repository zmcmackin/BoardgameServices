package com.boardgame.service.board;

import com.boardgame.bo.board.Board;
import com.boardgame.bo.board.Tile;
import com.boardgame.bo.board.Token;
import com.boardgame.dto.Game;
import com.boardgame.enums.GameObjectTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BoardService {

    @Autowired
    private LevelService levelService;

    @Autowired
    private TokenService tokenService;

    public Game updateTile(Game game, String uuid, int level, Integer x, Integer y, Tile updateTile) {
        if (StringUtils.isEmpty(uuid) && (x == null && y == null)) {
            throw new IllegalArgumentException("");
        }

        Board board = getBoard(game);

        Tile tile = levelService.getTile(board, uuid, level, x, y);

        if (updateTile != null) {
            updateTile.setId(tile.getId());

            levelService.setTileByPosition(levelService.getLevel(board, level), x, y, updateTile);
        }

        return game;
    }

    public Board getBoard(Game game) {
        game.gameObjects.putIfAbsent(GameObjectTypes.board, new Board());

        Board board = (Board) game.gameObjects.get(GameObjectTypes.board);

        return board;
    }

    public Game updateToken(Game game, String tokenId, int level, Integer x, Integer y, Token updateToken) {
        Board board = getBoard(game);

        if (tokenId != null) {
            if (board.getTokens().get(tokenId) == null) {
                throw new IllegalArgumentException("token identifier");
            }
        }

        Tile tile = null;
        if (x != null && y != null) {
            tile = levelService.getTileByPosition(board, level, x, y);
        }

        if (tokenId == null) {
            tokenId = tokenService.createToken(board, tile, updateToken.getName(), updateToken.getType(), updateToken.getOwner());
        } else if (tile != null) {
            tile.getTokenIds().add(tokenId);
        }

        board.getTokens().put(tokenId, updateToken);

        return game;

    }
}
