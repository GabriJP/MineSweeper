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
        super(frame, true);
        this.setTitle("Preferences");
        this.maxX = 0;
        this.maxY = 0;
        this.difficulty = Difficulty.EASY;
        this.createInterface();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void createInterface() {
        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelMaxXCells = new JLabel("Number of cells on the X axis");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        jPanel.add(labelMaxXCells, gridBagConstraints);

        JTextField textFieldMaxXCells = new JTextField(3);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        jPanel.add(textFieldMaxXCells, gridBagConstraints);

        JLabel labelMaxYCells = new JLabel("Number of cells on the Y axis");
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        jPanel.add(labelMaxYCells, gridBagConstraints);

        JTextField textFieldMaxYCells = new JTextField(3);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        jPanel.add(textFieldMaxYCells, gridBagConstraints);

        JLabel labelDifficulty = new JLabel("Difficulty");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        jPanel.add(labelDifficulty, gridBagConstraints);

        JComboBox<String> comboBoxDifficulty = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        jPanel.add(comboBoxDifficulty, gridBagConstraints);

        JButton buttonStart = new JButton("START");
        buttonStart.addActionListener(e -> {
            maxX = Integer.parseInt(textFieldMaxXCells.getText());
            maxY = Integer.parseInt(textFieldMaxYCells.getText());
            switch (comboBoxDifficulty.getSelectedIndex()) {
                case 0:
                    difficulty = Difficulty.EASY;
                    break;
                case 1:
                    difficulty = Difficulty.MEDIUM;
                    break;
                case 2:
                    difficulty = Difficulty.HARD;
                    break;
                default:
                    difficulty = null;
            }
            this.dispose();
        });
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        jPanel.add(buttonStart, gridBagConstraints);

        this.getContentPane().add(jPanel, BorderLayout.CENTER);
    }

    @Override
    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public int getMaxX() {
        return maxX;
    }

    @Override
    public int getMaxY() {
        return maxY;
    }
}
