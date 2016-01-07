package control;

import application.swing.Application;

public class NewGameCommand implements Command {

    private Application application;

    public NewGameCommand(Application application) {
        this.application = application;
    }

    @Override
    public void execute() {
        application.createNewGame();
    }
}
