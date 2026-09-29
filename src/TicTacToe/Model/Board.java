package TicTacToe.Model;

import TicTacToe.Enum.Symbol;
import TicTacToe.GameStateHandler.ConcreteStates.DrawState;
import TicTacToe.GameStateHandler.context.GameContext;
import TicTacToe.Model.Shared.Position;
import TicTacToe.Startegy.ConcreteStartergies.DiagonalStartegy;
import TicTacToe.Startegy.ConcreteStartergies.HorizontalStartegy;
import TicTacToe.Startegy.ConcreteStartergies.VerticalStartegy;
import TicTacToe.Startegy.WinningStartegy;

public class Board {

    public Symbol[][] board;
    int row;
    int col;
    private int movesCount = 0;

    private WinningStartegy[] winningStartegies;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new Symbol[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.board[i][j] = Symbol.EMPTY;
            }
        }
        winningStartegies = new WinningStartegy[]{
            new HorizontalStartegy(),
            new VerticalStartegy(),
            new DiagonalStartegy(),}; // Initialize with an empty array or appropriate strategies
    }

    //validation and insert part
    public boolean isValidMove(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return row >= 0 && row < this.row && col >= 0 && col < this.col && this.board[row][col] == Symbol.EMPTY;
    }

    public void makeMove(Position position, Symbol symbol) {
        this.board[position.getRow()][position.getCol()] = symbol;
        movesCount++;
    }

    public void checkGameState(GameContext context, Player player) {

        for (WinningStartegy strategy : winningStartegies) {

            if (strategy.checkWinner(player, this)) {
                context.next(player, true);
                return; // Exit the method after a win is detected
            }
        }

        if (movesCount == row * col) {
            if (context.isGameOver() == false) {
                context.setGameState(new DrawState());
                // context.next(player, true);
            }
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void printBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Symbol symbol = board[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }

                if (j < col - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < row - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

}
