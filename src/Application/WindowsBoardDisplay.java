package Application;

import model.Board;
import ui.BoardDialog;
import ui.BoardDisplay;

import javax.swing.*;
import java.util.Observable;

/**
 * Created by Gabriel on 19/11/2015.
 */
public class WindowsBoardDisplay extends JFrame implements BoardDisplay {

    private Board board;

    public WindowsBoardDisplay() {
        BoardDialog boardDialog = new WindowsBoardDialog(this);
        this.board = new Board(boardDialog.getMaxX(), boardDialog.getMaxY(), boardDialog.getDifficulty(), this);
    }

    private void buildInterface(){

    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void addBoard(Board board) {
        this.board = board;
    }

    @Override
    public void start() {
        this.setVisible(true);
    }
}
