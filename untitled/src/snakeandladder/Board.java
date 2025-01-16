package snakeandladder;
import java.util.concurrent.ThreadLocalRandom;
public class Board {
    Cell[][] board;
    public Board(int boardSize,int noOfSnakes,int noOfLadders){
        this.board = new Cell[boardSize][boardSize];
        createBoard(boardSize);
        addSnakes(noOfSnakes);
        addLadders(noOfLadders);
    }
    public void createBoard(int boardSize){
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                board[i][j] = new Cell();
            }
        }
    }

    public void addSnakes(int noOfSnakes){
        while(noOfSnakes>0){
            int start = ThreadLocalRandom.current().nextInt(1,board.length* board.length-1);
            int end = ThreadLocalRandom.current().nextInt(1,board.length* board.length-1);
            if (end >= start) {
                System.out.println("Invalid Snake");
                continue;
            }

             Jump snake = new Jump(start,end);
            System.out.println("snake is from"+snake.start+" "+snake.end);
            Cell c1=getCell(snake.getStart());
           c1.jump=snake;
           noOfSnakes--;

        }
    }
    public void addLadders(int noOfLadders){
        while(noOfLadders>0){
            int start = ThreadLocalRandom.current().nextInt(1,board.length* board.length-1);
            int end = ThreadLocalRandom.current().nextInt(1,board.length* board.length-1);
            if (end <= start) {
                System.out.println("Invalid Ladder");
                continue;

            }
            Jump ladder = new Jump(start,end);
            System.out.println("Ladder is from"+ladder.start+" "+ladder.end);
            Cell c1=getCell(ladder.getStart());
            c1.jump=ladder;
            noOfLadders--;
        }
    }
    public Cell getCell(int index){
        int row = index / board.length;
        int col = index % board.length;
        return board[row][col];
    }

}
