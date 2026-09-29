package TicTacToe.GameStateHandler.ConcreteStates;

import TicTacToe.Enum.Symbol;
import TicTacToe.GameStateHandler.GameState;
import TicTacToe.GameStateHandler.context.GameContext;
import TicTacToe.Model.Player;

public class OTurnState implements GameState {

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {

        if (hasWon) {
            context.setGameState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        } else {
            context.setGameState(new XTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
