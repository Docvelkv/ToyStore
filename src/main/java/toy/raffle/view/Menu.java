package toy.raffle.view;

import toy.raffle.view.commands.*;
import toy.raffle.view.interfaces.Command;
import toy.raffle.view.interfaces.View;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private  final List<Command> lstCom;

    public Menu(View view) {
        lstCom = new ArrayList<>();

        lstCom.add(new Raffle(view));
        lstCom.add(new Loading(view));
        lstCom.add(new Finish(view));
    }

    public int menuSize(){
        return lstCom.size();
    }

    public void showMenu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < menuSize(); i++){
            sb.append(i + 1)
                    .append("\t")
                    .append(lstCom.get(i).getDescription())
                    .append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public void execute(int numCommand){
        lstCom.get(numCommand - 1).execute();
    }
}
