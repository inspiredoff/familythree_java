package view.Menu;

import view.Command.*;
import view.ConsoleUI;
import view.OriginalMenu;

import java.util.ArrayList;

public class MenuHuman extends OriginalMenu {

    public MenuHuman(ConsoleUI consoleUI){
        super(consoleUI);
        this.commandList = new ArrayList<>();
        this.commandList.add(new DiedHuman(consoleUI));
        this.commandList.add(new SetParrent(consoleUI));
        this.commandList.add(new WendingHuman(consoleUI));
        this.commandList.add(new BackToTreeMenu(consoleUI));
    }
}
