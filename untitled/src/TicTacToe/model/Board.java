package TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;
    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public void setBoard(PlayingPiece[][] board) {
        this.board = board;
    }
    public boolean addPiece(PlayingPiece piece, int row, int col) {
        if (board[row][col] == null) {
            board[row][col] = piece;
            return true;
        }
        return false;
    }
    public List<List<Integer>> getFreeSpaces(){
        List<List<Integer>> freeSpaces = new ArrayList<List<Integer>>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    freeSpaces.add(new ArrayList<Integer>());
                    freeSpaces.get(freeSpaces.size()-1).add(i);
                    freeSpaces.get(freeSpaces.size()-1).add(j);
                }
            }
        }
        return freeSpaces;

    }

    public void displayBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    System.out.print("  ");
                }
                else{
                    System.out.print(board[i][j].pieceType.name()+" ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
