package com.boardgame.controllers.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boardgame.bo.board.Board;
import com.boardgame.service.board.BoardService;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/game/{name}/board")
	public @ResponseBody Board getBoard(@PathVariable("name") String name) {
		return boardService.getBoard(name);
	}

}
