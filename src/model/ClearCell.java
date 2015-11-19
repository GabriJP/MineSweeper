package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Gabriel on 14/11/2015.
 */
public class ClearCell extends Observable implements Cell {

    private boolean opened;
    private Observer board;
    private List<Cell> neighbours;

    public ClearCell(Observer board) {
        this.opened = false;
        this.neighbours = new LinkedList<>();
        this.board = board;
    }


    @Override
    public void open() {
        if(!this.opened){
            board.update(this, getMinesAround());
        }
    }

    @Override
    public void addNeighbour(Cell neighbour) {
        this.neighbours.add(neighbour);
    }

    private int getMinesAround(){
        int mines = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour instanceof MineCell){
                mines++;
            }
        }
        return mines;
    }
}
