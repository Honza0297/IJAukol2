package ija.ija2018.homework2;

import ija.ija2018.homework2.common.Game;
import ija.ija2018.homework2.board.Board;
import ija.ija2018.homework2.game.CheckerGame;
import ija.ija2018.homework2.game.ChessGame;

public abstract class GameFactory {
    public GameFactory()
    {

    }

    public static Game createChessGame(Board board)
    {
        return new ChessGame(board);
    }

    public static Game createCheckersGame(Board board)
    {
            return new CheckerGame(board);
    }
}
