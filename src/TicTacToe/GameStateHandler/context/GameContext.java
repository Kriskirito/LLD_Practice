package TicTacToe.GameStateHandler.context;

import TicTacToe.GameStateHandler.ConcreteStates.XTurnState;
import TicTacToe.GameStateHandler.GameState;
import TicTacToe.Model.Player;

public class GameContext {

    private GameState currState;

    public GameContext() {
        this.currState = new XTurnState();
    }

    public GameState getCurrentState() {
        return this.currState;
    }

    public void next(Player player, boolean hasWon) {
        currState.next(this, player, hasWon);
    }

    public boolean isGameOver() {
        return currState.isGameOver();
    }

    public void setGameState(GameState _GameState) {
        this.currState = _GameState;
    }
}
