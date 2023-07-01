package toy.raffle.view.commands;

import toy.raffle.view.interfaces.Command;
import toy.raffle.view.interfaces.View;

public class Raffle implements Command {
    private  final View view;

    public Raffle(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Разыграть и сохранить результат";
    }

    @Override
    public void execute() {
        view.raffle();
    }
}
