package view;

import view.Command.*;

import java.util.ArrayList;
import java.util.List;

public class MenuHuman extends OriginalMenu{

    public MenuHuman(ConsoleUI consoleUI){
        super(consoleUI);
        this.commandList = new ArrayList<>();
        this.commandList.add(new DiedHuman(consoleUI));
        this.commandList.add(new WendingHuman(consoleUI));
    }
}
