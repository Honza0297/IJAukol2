package ija.ija2018.homework2.game;

import ija.ija2018.homework2.common.Command;
import ija.ija2018.homework2.common.Field;
import ija.ija2018.homework2.common.Figure;
import ija.ija2018.homework2.common.Game;
import ija.ija2018.homework2.game.commands.MoveCommand;
import ija.ija2018.homework2.game.commands.MoveInvoker;
import ija.ija2018.homework2.game.figures.Pawn;
import ija.ija2018.homework2.game.figures.Rook;

public class ChessGame implements Game {

    private Board chessBoard;
    MoveInvoker invoker;

    public ChessGame(Board board)
    {
        chessBoard = board;
        SetBoard(chessBoard);

        invoker = new MoveInvoker();
    }

    private void SetBoard(Board board) {
        int max = board.getSize();
        board.getField(1, 1).put(new Rook(true));
        board.getField(max, 1).put(new Rook(true));
        board.getField(1, max).put(new Rook(false));
        board.getField(max, max).put(new Rook(false));
        for(int c = 1; c < max+1;c++)
        {
            board.getField(c, 2).put(new Pawn(true));
            board.getField(c, max-1).put(new Pawn(false));
        }
    }


    @Override
    public boolean move(Figure figure, Field field) {
        Command cmd = new MoveCommand(figure, figure.getPositionField(), field, field.get());
        return invoker.execute(cmd);
    }

    @Override
    public void undo() { invoker.undo();
    }
}
