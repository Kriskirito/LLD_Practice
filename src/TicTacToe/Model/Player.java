package TicTacToe.Model;

import TicTacToe.Enum.Symbol;
import TicTacToe.Startegy.PlayerStartegy;

public class Player {

    private PlayerStartegy playerStartegy;
    private Symbol symbol;

    public Player(Symbol symbol, PlayerStartegy playerStartegy) {
        this.symbol = symbol;
        this.playerStartegy = playerStartegy;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerStartegy getPlayerStartegy() {
        return playerStartegy;
    }
}
