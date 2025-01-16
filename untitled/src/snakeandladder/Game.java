package snakeandladder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playerList=new LinkedList<>();
    Player winner;

    Game()
    {
        intilaizeGame();
    }
    public void intilaizeGame()
    {
       this.board = new Board(10,5,5);
       this.dice = new Dice(1);
       addPlayers();
       this.winner=null;
    }

    public void addPlayers()
    {
        Player player1 = new Player("player1",1);
        Player player2 = new Player("player2",1);
        this.playerList.add(player1);
        this.playerList.add(player2);
    }

    public Player startGame()
    {
        while(winner==null)
        {
         Player player = playerList.poll();
         playerList.addLast(player);
         int currentPosition = player.getCurrentPosition();
         int diceRoll = dice.roll();
         System.out.println(player.getName()+" rolled "+diceRoll);
         System.out.println("Current Position "+currentPosition);
         currentPosition+=diceRoll;
         if(currentPosition>board.board.length*board.board.length-1)
             continue;
         int newPosition = jumpCheck(currentPosition);
         System.out.println("New Position "+newPosition);
         player.setCurrentPosition(newPosition);
         if(currentPosition==board.board.length*board.board.length-1)
         {
             winner=player;
         }
        }
        return winner;
    }
    public int jumpCheck(int currentPosition)
    {
        Cell cell = board.getCell(currentPosition);
        if(cell.jump!=null && cell.jump.getStart()==currentPosition)
        {
          String obj= cell.jump.start>cell.jump.end?"snake":"ladder";
          System.out.println("This jump is from "+cell.jump.start+" "+obj+" "+cell.jump.end);
          currentPosition=cell.jump.getEnd();
        }
        return currentPosition;
    }

}
