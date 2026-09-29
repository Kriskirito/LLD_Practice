package TicTacToe;

import TicTacToe.Model.Game;
import TicTacToe.Startegy.ConcreteStartergies.HumanPlayerStartegy;
import TicTacToe.Startegy.PlayerStartegy;

public class Main {

    public static void main(String[] args) {
        // Your code here
        System.out.println("Hello, Tic Tac Toe!");

        PlayerStartegy playerXStrategy = new HumanPlayerStartegy("Player X");
        PlayerStartegy playerOStrategy = new HumanPlayerStartegy("Player O");
        Game game = new Game(playerXStrategy, playerOStrategy);
        game.start();
    }
}
