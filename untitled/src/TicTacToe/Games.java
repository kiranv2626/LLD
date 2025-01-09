package TicTacToe;

import TicTacToe.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Games {
    Deque<Player> players;
    Board board;

    public Games() {
        IntilizeGame();
    }

    private void IntilizeGame() {
        players = new LinkedList<>();
        PlayingPieceX playingPieceX = new PlayingPieceX();
        PlayingPieceO playingPieceO = new PlayingPieceO();

        players.add(new Player("Player 1", playingPieceX));
        players.add(new Player("Player 2", playingPieceO));
        board = new Board(3);
    }
    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player currentPlayer = players.removeFirst();
            List<List<Integer>> freeSpaces = board.getFreeSpaces();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }
            System.out.println("Player "+currentPlayer.getName()+" turn" +"Enter Row,Column");
            Scanner sc = new Scanner(System.in);
            String s= sc.nextLine();
            String [] values=s.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);
            boolean isAdded = board.addPiece(currentPlayer.getPiece(), row, col);
            if(!isAdded){
                System.out.println("Invalid Move");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);
            boolean isWinner = isWinner(currentPlayer.getPiece(),row,col);
            board.displayBoard();
            if (isWinner) {
                noWinner = false;
                return currentPlayer.getName();

            }

        }
        return "Tie";
    }
    public boolean isWinner(PlayingPiece piece, int row, int col){
     PieceType pieceType = piece.getPieceType();
     boolean r=true;
     boolean c=false;
     boolean d=true;
     boolean a=true;
     for(int i=0;i<board.getSize();i++){
         if(board.getBoard()[row][i]==null || board.getBoard()[row][i].getPieceType()!=pieceType){
             r = false;
         }
     }
     for(int i=0;i<board.getSize();i++){
         if(board.getBoard()[i][col]==null || board.getBoard()[i][col].getPieceType()!=pieceType){
             c = false;
         }
     }
     for(int i=0,j=0;i<board.getSize()&&j<board.getSize();i++,j++){
         if(board.getBoard()[i][j]==null || board.getBoard()[i][j].getPieceType()!=pieceType){
             d = false;
     }
    }
     for(int i=0,j=board.getSize()-1;i<board.getSize()&&j>=0;i++,j--){
         if(board.getBoard()[i][j]==null || board.getBoard()[i][j].getPieceType()!=pieceType){
             a = false;
         }
     }
     return r || c || d || a;
    }

}
