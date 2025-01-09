package TicTacToe.model;

import TicTacToe.Games;

public class Main {
    public static void main(String[] args) {
        Games games = new Games();
        System.out.println("Winner of the game is"+games.startGame());
    }
}
