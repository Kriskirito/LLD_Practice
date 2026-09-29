package TicTacToe.GameStateHandler;

import TicTacToe.GameStateHandler.context.GameContext;
import TicTacToe.Model.Player;

public interface GameState {

    void next(GameContext context, Player player, boolean hasWon);

    boolean isGameOver();
}
