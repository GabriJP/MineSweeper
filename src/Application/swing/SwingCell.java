package application.swing;

import model.Cell;

import javax.swing.*;
import java.awt.*;

public abstract class SwingCell extends JButton implements Cell {

    public SwingCell() {
        this.setPreferredSize(new Dimension(50, 50));
    }
}