package com.boardgame.service.script.board

import com.boardgame.bo.board.Board
import com.boardgame.bo.board.Tile
import com.boardgame.bo.board.Token
import com.boardgame.dto.Game
import com.boardgame.dto.User
import com.boardgame.enums.board.TokenType
import com.boardgame.service.board.BoardService
import com.boardgame.service.board.LevelService
import com.boardgame.service.board.TokenService
import groovy.json.JsonOutput
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardTest {

    @Autowired
    BoardService boardService;

    @Autowired
    LevelService levelService;

    @Autowired
    TokenService tokenService;

    @Test
    public void tileTest() {
        def (Game game, Board board, List positions) = buildDefaultBoardGame()

        println(JsonOutput.toJson(board))

        positions.each {
            int level, int x, int y ->

                Assert.assertNotNull board.getLevels().get(level)
                Assert.assertNotNull board.getLevels().get(level).getTiles().get(x)
                Assert.assertNotNull board.getLevels().get(level).getTiles().get(x).get(y)
        }

    }

    private List buildDefaultBoardGame() {
        Game g = new Game()

        List positions = buildPositions()
        buildDefaultMap(positions, g)

        Board board = boardService.getBoard(g);
        [g, board, positions]
    }

    private List buildDefaultMap(List positions, Game g) {
        positions.each {
            int level, int x, int y ->
                boardService.updateTile(g, null, level, x, y, null)
        }
    }

    private List buildPositions() {
        def positions = []
        (0..2).each {
            level ->
                (0..2).each {
                    x ->
                        (0..2).each {
                            y ->
                                positions << [level, x, y]
                        }
                }
        }
        positions
    }


    @Test
    public void tokenTest() {
        def (Game game, Board board, List positions) = buildDefaultBoardGame()

        User user = new User();
        user.setName("Unit Test User");

        def idx = 0;
        def ticktack = ['','X','O']
        positions.each {
            int level, int x, int y ->

                boardService.updateToken(game, null, level, x, y, new Token(name: "Token ${idx++}", traits:["ticktack":ticktack[Math.round(Math.random()*ticktack.size()) as Integer]]))
        }

        println(JsonOutput.toJson(board))

        Assert.assertTrue 'made plenty of tokens', board.getTokens().size() > positions.size()
    }
}
