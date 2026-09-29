package TicTacToe.Startegy.ConcreteStartergies;

import TicTacToe.Startegy.WinningStartegy;
import TicTacToe.Enum.Symbol;
import TicTacToe.Model.Board;
import TicTacToe.Model.Shared.Position;
import TicTacToe.Model.Player;

public class VerticalStartegy implements WinningStartegy {

    @Override
    public boolean checkWinner(Player player, Board board) {

        for (int col = 0; col < board.getCol(); col++) {
            boolean colWin = true;
            for (int row = 0; row < board.getRow(); row++) {
                if (board.board[row][col] != player.getSymbol()) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) {
                return true;
            }
        }
        return false;
    }
}
