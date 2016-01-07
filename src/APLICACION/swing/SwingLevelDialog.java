package APLICACION.swing;

import model.Level;

import javax.swing.*;
import java.awt.*;

public class SwingLevelDialog extends JDialog {

    private Level level;

    public SwingLevelDialog(Frame owner) {
        super(owner, true);
        this.setLocationRelativeTo(owner);
        this.setTitle("Choose level");
        this.level = Level.Easy;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        deplyUI();
        this.pack();
    }

    private void deplyUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;

        JLabel chooseLevelText = new JLabel("Please, choose a difficulty:");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel.add(chooseLevelText, gridBagConstraints);

        JComboBox<String> levelComboBox = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(levelComboBox, gridBagConstraints);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            level = Level.valueOf((String) levelComboBox.getSelectedItem());
            dispose();
        });
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panel.add(okButton, gridBagConstraints);

        this.getContentPane().add(panel, BorderLayout.CENTER);
    }

    public Level getLevel() {
        return level;
    }
}
