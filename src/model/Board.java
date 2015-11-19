package model;

import ui.BoardDisplay;

import java.util.Random;

/**
 * Created by Gabriel on 14/11/2015.
 */
public class Board {

    private Cell[][] board;

    public Board(int maxX, int maxY, Difficulty difficulty, BoardDisplay boardDisplay) {
        if(maxX > 1 && maxY > 1) {
            this.board = new Cell[maxX][maxY];
            fillBoard(boardDisplay);
        } else {
            System.err.println("DefaultBoard Constructor invalid parameters");
            System.exit(1);
        }
    }

    private void fillBoard(BoardDisplay boardDisplay){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Random().nextBoolean()? new MineCell(boardDisplay) : new ClearCell(boardDisplay);
            }
        }
    }

    public void touchPosition(int x, int y) {
        board[x][y].open();
    }

    public int getMaxX() {
        return board.length;
    }

    public int getMaxY() {
        return board[0].length;
    }
}
