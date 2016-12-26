package com.boardgame.service.board;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardgame.bo.board.Board;
import com.boardgame.bo.board.Connection;
import com.boardgame.bo.board.Level;
import com.boardgame.bo.board.Tile;
import org.springframework.util.StringUtils;

@Service
public class LevelService {

    @Autowired
    private TokenService tokenService;

    public Tile getTileByPosition(Board board, int level, int x, int y) {
        Tile tile = getTileByPosition(board, getLevel(board, level), x, y);

        return tile;
    }

    public Tile getTileById(Board board, String tileId) {
        for (Level level : board.getLevels().values()) {
            Tile t = getTileById(level, tileId);
            if (t != null) {
                return t;
            }
        }

        return null;
    }

    public Tile getTile(Board board, String uuid, int level, Integer x, Integer y) {
        Tile uuidTile = null, positionTile = null;

        if (x != null && y != null) {
            positionTile = uuidTile = getTileByPosition(board, level, x, y);
            if (uuidTile != null && !StringUtils.isEmpty(uuid) && !uuidTile.getId().equals(uuid)) {
                uuidTile = null;
            }
        }

        if (uuidTile == null && !StringUtils.isEmpty(uuid)) {
            uuidTile = getTileById(board, uuid);
        }

        if (!uuidTile.getId().equals(positionTile.getId())) {
            //uh oh tile move
            setTileByPosition(getLevel(board, positionTile.getLevel()), positionTile.getX(), positionTile.getY(), uuidTile);

            setTileByPosition(getLevel(board, uuidTile.getLevel()), uuidTile.getX(), uuidTile.getY(), positionTile);
        }
        return uuidTile;
    }

    public Tile setTileByPosition(Level level, int x, int y, Tile tile) {
        tile.setLevel(level.getLevel());
        tile.setX(x);
        tile.setY(y);

        level.getTiles().putIfAbsent(x, new HashMap<>());
        return level.getTiles().get(x).put(y, tile);
    }

    public Tile getTileByPosition(Board board, Level level, int x, int y) {
        level.getTiles().putIfAbsent(x, new HashMap<>());
        level.getTiles().get(x).put(y, buildTile(board, level));

        Tile tile = level.getTiles().get(x).get(y);

        tile.setX(x);
        tile.setY(y);
        tile.setLevel(level.getLevel());

        return tile;
    }

    public Level getLevel(Board board, int level) {
        board.getLevels().putIfAbsent(level, buildLevel());

        Level lvl = board.getLevels().get(level);

        lvl.setLevel(level);

        return lvl;
    }

    public Tile getTileById(Level level, String tileId) {
        X:
        for (Map.Entry<Integer, Map<Integer, Tile>> xLoc : level.getTiles().entrySet()) {
            Y:
            for (Map.Entry<Integer, Tile> yLoc : xLoc.getValue().entrySet()) {

                Tile tile = yLoc.getValue();

                if (tileId.equals(tile.getId())) {
                    tile.setX(xLoc.getKey());
                    tile.setY(yLoc.getKey());
                    tile.setLevel(level.getLevel());

                    return tile;
                }
            }
        }

        return null;
    }

    private Tile buildTile(Board board, Level level) {
        Tile tile = new Tile();

        tile.setId(UUID.randomUUID().toString());

        if (board.getTokens().isEmpty()) {
            tokenService.createStartToken(board, tile);
        }

        return tile;
    }

    private Level buildLevel() {
        return new Level();
    }

    public Connection getConnection(Tile from, int toLevel, int toX, int toY) {
        Connection toConn = buildConnection(toLevel, toX, toY);

        for (Connection tConn : from.getConnections()) {
            if (toConn.equals(tConn)) {
                toConn = tConn;
                break;
            }
        }

        return toConn;
    }

    private Connection buildConnection(int toLevel, int toX, int toY) {
        Connection conn = new Connection(toLevel, toX, toY);

        conn.setId(UUID.randomUUID().toString());

        return conn;
    }
}
