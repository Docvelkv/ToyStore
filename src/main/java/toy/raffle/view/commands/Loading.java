package toy.raffle.view.commands;

import toy.raffle.view.interfaces.Command;
import toy.raffle.view.interfaces.View;

public class Loading implements Command {

    private final View view;

    public Loading(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть сохранённый файл";
    }

    @Override
    public void execute() {
        view.loading();
    }
}
