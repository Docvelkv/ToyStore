package toy.raffle.view.commands;

import toy.raffle.view.interfaces.Command;
import toy.raffle.view.interfaces.View;

public class Finish implements Command {

    private final View view;

    public Finish(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        view.finish();
    }
}
