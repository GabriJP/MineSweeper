package Application;

import ui.BoardDisplay;

/**
 * Created by Gabriel on 14/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        BoardDisplay boardDisplay = new WindowsBoardDisplay();
        boardDisplay.start();
    }
}
