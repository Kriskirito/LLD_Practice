package TicTacToe.Startegy.ConcreteStartergies;

import TicTacToe.Startegy.WinningStartegy;
import TicTacToe.Enum.Symbol;
import TicTacToe.Model.Board;
import TicTacToe.Model.Shared.Position;
import TicTacToe.Model.Player;

public class HorizontalStartegy implements WinningStartegy {

    @Override
    public boolean checkWinner(Player player, Board board) {

        for (int row = 0; row < board.getRow(); row++) {
            boolean rowWin = true;
            for (int col = 0; col < board.getCol(); col++) {
                if (board.board[row][col] != player.getSymbol()) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) {
                return true;
            }
        }
        return false;
    }

}
