package model;

import ui.BoardDisplay;

/**
 * Created by Gabriel on 14/11/2015.
 */
public class Board {

    private Cell[][] board;

    public Board(int maxX, int maxY, Difficulty difficulty, BoardDisplay boardDisplay) {
        if (maxX > 1 && maxY > 1) {
            this.board = new Cell[maxX][maxY];
            fillBoard(boardDisplay, difficulty, maxX, maxY);
        } else {
            System.err.println("DefaultBoard Constructor invalid parameters");
            System.exit(1);
        }
    }

    private void fillBoard(BoardDisplay boardDisplay, Difficulty difficulty, int maxX, int maxY) {
        long maxPositions = maxX * maxY;
        long minesLeft = 0;
        switch (difficulty) {
            case EASY:
                minesLeft = maxPositions / 7;
                break;
            case MEDIUM:
                minesLeft = maxPositions / 5;
                break;
            case HARD:
                minesLeft = maxPositions >> 1;
                break;
        }
        while (minesLeft > 0) {
            int randX = (int) (Math.random() * maxX);
            int randY = (int) (Math.random() * maxY);
            if (board[randX][randY] == null) {
                board[randX][randY] = new MineCell(boardDisplay, randX, randY);
                minesLeft--;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == null) {
                    board[i][j] = new ClearCell(boardDisplay, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] instanceof ClearCell){
                    if (i-1 >= 0) {
                        if(j-1 >= 0) board[i][j].addNeighbour(board[i - 1][j - 1]);
                        board[i][j].addNeighbour(board[i - 1][j]);
                        if(j+1<board[0].length) board[i][j].addNeighbour(board[i - 1][j + 1]);
                    }
                    if(j-1 >= 0) board[i][j].addNeighbour(board[i][j-1]);
                    if(j+1<board[0].length) board[i][j].addNeighbour(board[i][j+1]);

                    if(i+1 < board.length) {
                        if(j-1 >= 0) board[i][j].addNeighbour(board[i + 1][j - 1]);
                        board[i][j].addNeighbour(board[i + 1][j]);
                        if(j+1<board[0].length) board[i][j].addNeighbour(board[i + 1][j + 1]);
                    }
                }
            }
        }
    }

    public void openPosition(int x, int y) {
        board[x][y].open();
    }

    public int getMaxX() {
        return board.length;
    }

    public int getMaxY() {
        return board[0].length;
    }

}
