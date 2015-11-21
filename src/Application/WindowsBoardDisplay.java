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
    private boolean gameFinished;

    public WindowsBoardDisplay() {
        this.gameFinished = false;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        BoardDialog boardDialog = new WindowsBoardDialog(this);
        this.board = new Board(boardDialog.getMaxX(), boardDialog.getMaxY(), boardDialog.getDifficulty(), this);
        mineField = new JButton[board.getMaxX()][board.getMaxY()];
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[0].length; j++) {
                mineField[i][j] = new JButton();
                mineField[i][j].setPreferredSize(new Dimension(50, 50));
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
        this.setLayout(new GridLayout(board.getMaxX(), board.getMaxY()));
        for (JButton[] mineFieldLine : mineField) {
            for (JButton jButton : mineFieldLine) {
                this.getContentPane().add(jButton);
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
            if(!gameFinished){
                gameFinished = true;
                mineField[openResult.getX()][openResult.getY()].setText(".");
            }
            mineField[openResult.getX()][openResult.getY()].setEnabled(false);
            for (int i = 0; i < board.getMaxX(); i++) {
                for (int j = 0; j < board.getMaxY(); j++) {
                    board.openPosition(i, j);
                }
            }
        } else {
            mineField[openResult.getX()][openResult.getY()].setEnabled(false);
            mineField[openResult.getX()][openResult.getY()].setText(String.valueOf(openResult.getMinesAround()));
        }
    }

    @Override
    public void start() {
        this.setVisible(true);
    }
}
