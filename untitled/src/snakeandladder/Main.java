package snakeandladder;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player player = game.startGame();
        System.out.println("Winner of the game is "+player.getName());
    }
}
