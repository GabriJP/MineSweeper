package model;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Gabriel on 30/10/2015.
 */
public class MineCell extends Observable implements Cell {

    private final int x;
    private final int y;
    private boolean opened;
    private Observer board;

    public MineCell(Observer board, int x, int y) {
        this.x = x;
        this.y = y;
        this.opened = false;
        this.board = board;
    }

    @Override
    public void open() {
        if (!this.opened) {
            this.opened = true;
            this.board.update(this, new OpenResult(x, y, -1));
        }
    }
}
