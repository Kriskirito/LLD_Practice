package TicTacToe.Startegy;

import TicTacToe.Model.Shared.Position;
import TicTacToe.Model.Board;

public interface PlayerStartegy {

    // make move is the method that will be implemented by different player strategies to decide their next move.
    Position makeMove(Board board);
}
