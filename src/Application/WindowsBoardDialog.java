package Application;

import model.Difficulty;
import ui.BoardDialog;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gabriel on 19/11/2015.
 */
public class WindowsBoardDialog extends JDialog implements BoardDialog {

    private int maxX;
    private int maxY;
    private Difficulty difficulty;

    public WindowsBoardDialog(Frame frame) {
        super(frame);
        this.setModal(true);
        this.maxX = 0;
        this.maxY = 0;
        this.difficulty = Difficulty.EASY;
        createInterface();
        this.setVisible(true);
    }

    private void createInterface() {

    }

    @Override
    public Difficulty getDifficulty() {
        return null;
    }

    @Override
    public int getMaxX() {
        return 0;
    }

    @Override
    public int getMaxY() {
        return 0;
    }
}
