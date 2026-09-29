package TicTacToe.Model;

import TicTacToe.Enum.Symbol;
import TicTacToe.GameStateHandler.ConcreteStates.OWonState;
import TicTacToe.GameStateHandler.ConcreteStates.XWonState;
import TicTacToe.GameStateHandler.GameState;
import TicTacToe.GameStateHandler.context.GameContext;
import TicTacToe.Model.Shared.Position;
import TicTacToe.Startegy.PlayerStartegy;

public class Game {

    private Board board;
    private Player playerX;
    private Player playerO;
    private GameContext gameContext;
    private Player currentPlayer;

    public Game(PlayerStartegy playerXStrategy, PlayerStartegy playerOStrategy) {
        this.board = new Board(3, 3);
        this.playerX = new Player(Symbol.X, playerXStrategy);
        this.playerO = new Player(Symbol.O, playerOStrategy);
        this.currentPlayer = playerX;
        this.gameContext = new GameContext();
    }

    public void start() {
        System.out.println("Game started!");

        do {

            board.printBoard();

            Position move = currentPlayer.getPlayerStartegy().makeMove(this.board);

            board.makeMove(move, currentPlayer.getSymbol());

            board.checkGameState(gameContext, currentPlayer);

            switchPlayer();

        } while (!gameContext.isGameOver());

        annouceResult();
    }

    public void switchPlayer() {

        this.currentPlayer = (this.currentPlayer == this.playerX) ? this.playerO : this.playerX;
    }

    public void annouceResult() {

        GameState state = gameContext.getCurrentState();

        if (state instanceof XWonState) {
            System.out.println("Player X won!");
        } else if (state instanceof OWonState) {
            System.out.println("Player O won!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
