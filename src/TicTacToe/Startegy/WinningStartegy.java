package TicTacToe.Startegy;

import TicTacToe.Model.Player;
import TicTacToe.Model.Board;

public interface WinningStartegy {

    public boolean checkWinner(Player player, Board board);
}
