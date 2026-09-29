package TicTacToe.Startegy.ConcreteStartergies;

import TicTacToe.Model.Board;
import TicTacToe.Model.Player;
import TicTacToe.Startegy.WinningStartegy;

public class DiagonalStartegy implements WinningStartegy {

    @Override
    public boolean checkWinner(Player player, Board board) {
        // Implement the logic to check for a diagonal win

        for (int i = 0; i < board.getRow(); i++) {
            if (board.board[i][i] != player.getSymbol()) {
                return false;
            }
        }
        return true;
    }
}
