package application.swing;

import model.Board;
import model.Cell;

import javax.swing.*;
import java.awt.*;

public abstract class SwingCell extends JButton implements Cell {

    protected final Board board;

    public SwingCell(Board board) {
        this.board = board;
        this.setPreferredSize(new Dimension(50, 50));
    }

    @Override
    public boolean isOpened() {
        return !this.isEnabled();
    }
}