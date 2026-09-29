package TicTacToe.GameStateHandler.ConcreteStates;

import TicTacToe.Enum.Symbol;
import TicTacToe.GameStateHandler.GameState;
import TicTacToe.GameStateHandler.context.GameContext;
import TicTacToe.Model.Player;

public class OWonState implements GameState {

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
