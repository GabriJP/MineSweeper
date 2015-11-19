package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Gabriel on 30/10/2015.
 */
public class MineCell extends Observable implements Cell {

    private boolean opened;
    private List<Cell> neighbours;
    private Observer board;

    public MineCell(Observer board) {
        this.opened = false;
        this.neighbours = new LinkedList<>();
        this.board = board;
    }

    @Override
    public void open() {
        if(!this.opened){
            this.board.update(this, -1);
        }
    }

    @Override
    public void addNeighbour(Cell neighbour) {
        this.neighbours.add(neighbour);
    }
}