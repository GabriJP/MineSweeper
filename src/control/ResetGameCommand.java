package control;

import application.swing.Application;

public class ResetGameCommand implements Command {

    private Application application;

    public ResetGameCommand(Application application) {
        this.application = application;
    }

    @Override
    public void execute() {
        application.resetGame();
    }
}
