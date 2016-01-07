package application.swing;

import model.Cell;
import model.ClearCell;
import model.MineCell;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SwingClearCell extends SwingCell implements ClearCell {

    private List<Cell> neighbours;
    private int minesAround;


    public SwingClearCell() {
        neighbours = new LinkedList<>();
        this.setSize(new Dimension(20, 20));
        this.setMinimumSize(new Dimension(20, 20));
        this.addActionListener(e -> open());
    }

    @Override
    public void open() {
        if (this.isEnabled()) {
            this.setEnabled(false);
            if (minesAround == 0) {
                neighbours.forEach(Cell::open);
            } else {
                this.setText(String.valueOf(minesAround));
            }
        }
    }

    @Override
    public void addNeighbour(Cell neighbour) {
        if (neighbour != null) {
            neighbours.add(neighbour);
            if (neighbour instanceof MineCell) {
                minesAround++;
            }
        }
    }
}
