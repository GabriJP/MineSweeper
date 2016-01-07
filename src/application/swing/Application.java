package application.swing;

import control.Command;
import control.NewGameCommand;
import control.ResetGameCommand;
import model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Application extends JFrame {

    private Map<String, Command> commands = new HashMap<>();
    private Level level;

    public static void main(String[] args) {
        new Application().setVisible(true);
    }

    public Application() {
        super("El buscaminas molón");
        createCommands();
        deployUI();
    }

    private void createCommands() {
        commands.put("New game", new NewGameCommand(this));
        commands.put("Reset game", new ResetGameCommand(this));
    }

    private void deployUI() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setMinimumSize(new Dimension(500,500));
        this.setJMenuBar(createMenuBar());
        this.createNewGame();
    }

    public void createNewGame() {
        level = askForLevel();
        resetGame();
        this.repaint();
    }

    private Level askForLevel(){
        SwingLevelDialog dialog = new SwingLevelDialog(this);
        dialog.setVisible(true);
        return dialog.getLevel();
    }

    public void resetGame(){
        setBoard(new SwingBoard(level));
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(newGameItem());
        menuBar.add(resetGameItem());
        return menuBar;
    }

    private JMenuItem resetGameItem() {
        JMenuItem menuItem = new JMenuItem("Reset game");
        menuItem.setMnemonic('r');
        menuItem.addActionListener(execute("Reset game"));
        return menuItem;
    }

    private JMenuItem newGameItem() {
        JMenuItem menuItem = new JMenuItem("New game");
        menuItem.setMnemonic('n');
        menuItem.addActionListener(execute("New game"));
        return menuItem;
    }

    private ActionListener execute(String command) {
        return e -> commands.get(command).execute();
    }

    public void setBoard(SwingBoard board){
        this.add(board, BorderLayout.CENTER);
        this.pack();
    }
}
