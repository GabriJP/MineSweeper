package model;


/**
 * Created by Gabriel on 14/11/2015.
 */
public interface Cell {
    void open();

    void addNeighbour(Cell neighbour);
}
