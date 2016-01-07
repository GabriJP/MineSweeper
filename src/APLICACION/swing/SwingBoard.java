package APLICACION.swing;

import model.Board;
import model.Cell;
import model.ClearCell;
import model.Level;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SwingBoard extends JPanel implements Board {

    private Level level;
    private List<SwingCell> board;
    private boolean finished = false;

    public boolean isFinished() {
        return finished;
    }

    private static final int[] mineCells = new int[]{10, 40, 99};
    private static final int[] clearCells = new int[]{71, 216, 385};

    public SwingBoard(Level level) {
        this.level = level;
        this.board = new ArrayList<>(getCellQuantity());
        this.setLayout(new GridLayout(this.getRowQuantity(), this.getColumnQuantity()));
        this.createCells();
        this.addNeighbours();
        this.deploy();
    }

    private void deploy() {
        board.forEach(this::add);
    }

    private void createCells() {
        Set<Integer> minesPositions = new HashSet<>();
        int mineCellQuantity = getMineCellQuantity();
        while (minesPositions.size() < mineCellQuantity) {
            minesPositions.add(getRandomBetween(0, getCellQuantity() - 1));
        }
        for (int i = 0; i < getCellQuantity(); i++) {
            board.add(minesPositions.contains(i) ? new SwingMineCell(this) : new SwingClearCell());
        }
    }

    private void addNeighbours() {
        for (int i = 0; i < getRowQuantity(); i++) {
            for (int j = 0; j < getColumnQuantity(); j++) {
                if (getCellAt(i, j) instanceof ClearCell) {
                    ClearCell current = (ClearCell) getCellAt(i, j);
                    if (current != null) {
                        current.addNeighbour(getCellAt(i - 1, j - 1));
                        current.addNeighbour(getCellAt(i - 1, j));
                        current.addNeighbour(getCellAt(i - 1, j + 1));
                        current.addNeighbour(getCellAt(i, j - 1));
                        current.addNeighbour(getCellAt(i, j + 1));
                        current.addNeighbour(getCellAt(i + 1, j - 1));
                        current.addNeighbour(getCellAt(i + 1, j));
                        current.addNeighbour(getCellAt(i + 1, j + 1));
                    }
                }
            }
        }
    }

    private Cell getCellAt(int row, int column) {
        if (row >= 0 && row < getRowQuantity() && column >= 0 && column < getColumnQuantity()) {
            return board.get(row * getColumnQuantity() + column);
        } else {
            return null;
        }
    }

    private int getRowQuantity() {
        return getColumnQuantity();
    }

    private int getRandomBetween(int first, int last) {
        return (int) (Math.random() * (last - first + 1) + first);
    }

    private int getColumnQuantity() {
        return (int) Math.sqrt(getCellQuantity());
    }

    @Override
    public void openAll() {
        this.finished = true;
        board.forEach(Cell::open);
    }

    private int getCellQuantity() {
        return getMineCellQuantity() + getClearCellQuantity();
    }

    private int getMineCellQuantity() {
        return mineCells[level.ordinal()];
    }

    private int getClearCellQuantity() {
        return clearCells[level.ordinal()];
    }
}
