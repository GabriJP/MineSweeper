package Application;

import model.Board;
import model.OpenResult;
import ui.BoardDialog;
import ui.BoardDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * Created by Gabriel on 19/11/2015.
 */
public class WindowsBoardDisplay extends JFrame implements BoardDisplay {

    private Board board;
    private JButton[][] mineField;

    public WindowsBoardDisplay() {
        BoardDialog boardDialog = new WindowsBoardDialog(this);
        this.board = new Board(boardDialog.getMaxX(), boardDialog.getMaxY(), boardDialog.getDifficulty(), this);
        mineField = new JButton[board.getMaxX()][board.getMaxY()];
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[0].length; j++) {
                mineField[i][j] = new JButton();
                final int finalI = i;
                final int finalJ = j;
                mineField[i][j].addActionListener(e -> board.openPosition(finalI, finalJ));
            }
        }
        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> reset());
        buildInterface();
    }

    private void buildInterface() {
        this.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[0].length; j++) {
                this.getContentPane().add(mineField[i][j]);
            }
        }
        setResizable(false);
        pack();
    }

    private void reset() {

    }

    @Override
    public void update(Observable cell, Object result) {
        OpenResult openResult = (OpenResult) result;
        if (openResult.getMinesAround() == -1) {

        } else {
            mineField[openResult.getX()][openResult.getY()].setVisible(false);
        }
    }

    @Override
    public void start() {
        this.setVisible(true);
    }
}
