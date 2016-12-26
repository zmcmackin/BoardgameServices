package com.boardgame.controllers.board;

import com.boardgame.bo.board.*;
import com.boardgame.dto.Game;
import com.boardgame.service.GameService;
import com.boardgame.service.board.BoardService;
import com.boardgame.service.board.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private GameService gameService;

    @RequestMapping("/game/{name}/board")
    public
    @ResponseBody
    Board getBoard(@PathVariable("name") String name) {
        Game g = gameService.getGameByName(name);
        return boardService.getBoard(g);
    }

    @RequestMapping(value = "/game/{name}/tile/update")
    public
    @ResponseBody
    Game updateTile(@PathVariable("name") String name,
                    @RequestParam(value = "uuid", required = false) String uuid,
                    @RequestParam(value = "x", required = false) Integer x,
                    @RequestParam(value = "y", required = false) Integer y,
                    @RequestParam(value = "level", required = false) int level,
                    @RequestBody Tile tile) {
        Game g = gameService.getGameByName(name);

        boardService.updateTile(g, uuid, x, y, level, tile);

        gameService.save(g);

        return g;
    }

    @RequestMapping(value = "/game/{name}/token/update")
    public
    @ResponseBody
    Game updateToken(@PathVariable("name") String name,
                     @RequestParam(value = "id") String id,
                     @RequestParam(value = "level", required = false) int level,
                     @RequestParam(value = "x", required = false) Integer x,
                     @RequestParam(value = "y", required = false) Integer y,
                     @RequestBody Token token) {
        Game g = gameService.getGameByName(name);

        boardService.updateToken(g, id, level, x, y, token);

        gameService.save(g);

        return g;
    }

//	@RequestMapping(value="/game/{name}/connection/update")
//	public @ResponseBody Connection updateConnection(@PathVariable("name") String name,
//										@RequestBody(required = true) Connection c) {
//		return boardService.updateConnection(name);
//	}


}
