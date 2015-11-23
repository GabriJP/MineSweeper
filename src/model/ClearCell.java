package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Gabriel on 14/11/2015.
 */
public class ClearCell extends Observable implements Cell {

    private final int x;
    private final int y;
    private boolean opened;
    private Observer board;
    private List<Cell> neighbours;

    public ClearCell(Observer board, int x, int y) {
        this.x = x;
        this.y = y;
        this.opened = false;
        this.neighbours = new LinkedList<>();
        this.board = board;
    }


    @Override
    public void open() {
        if (!this.opened) {
            opened = true;
            board.update(this, new OpenResult(x, y, getMinesAround()));
        }
    }

    public void addNeighbour(Cell neighbour) {
        this.neighbours.add(neighbour);
    }

    private int getMinesAround() {
        int mines = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour instanceof MineCell) {
                mines++;
            }
        }
        if (mines == 0) {
            neighbours.forEach(Cell::open);
        }
        return mines;
    }
}
