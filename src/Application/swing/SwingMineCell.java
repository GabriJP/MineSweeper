package application.swing;

import model.Board;
import model.MineCell;

import java.awt.*;

public class SwingMineCell extends SwingCell implements MineCell {

    private Board board;

    public SwingMineCell(Board board) {
        this.board = board;
        this.setSize(new Dimension(20, 20));
        this.setMinimumSize(new Dimension(20, 20));
        this.addActionListener(e -> open());
    }

    @Override
    public void open() {
        if (this.isEnabled()) {
            this.setEnabled(false);
            if (!board.isFinished()) {
                this.setText("*");
                board.openAll();
            }
        }
    }
}
