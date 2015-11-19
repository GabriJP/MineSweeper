package ui;

import model.Board;

import java.util.Observer;

/**
 * Created by Gabriel on 19/11/2015.
 */
public interface BoardDisplay extends Observer {

    void addBoard(Board board);
    void start();
}
