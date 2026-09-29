package TicTacToe.Startegy.ConcreteStartergies;

import java.util.Scanner;
import TicTacToe.Model.Board;
import TicTacToe.Model.Shared.Position;
import TicTacToe.Startegy.PlayerStartegy;

public class HumanPlayerStartegy implements PlayerStartegy {

    public String name;
    public Scanner scanner;

    public HumanPlayerStartegy(String name) {
        this.name = name;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {

        while (true) {
            try {
                System.out.println("Enter row [0-2] and column [0-2] for your move:");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Position position = new Position(row, col);

                if (board.isValidMove(position)) {
                    return position;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numbers for row and column.");
                scanner.nextLine(); // clear the invalid input
            }
        }

        // if (board.isValidMove(position)) {
        //     return position;
        // } else {
        //     System.out.println("Invalid move. Try again.");
        //     return makeMove(board);
        // }
        // return position;
    }
}
