package view;

import view.Command.*;

import java.util.ArrayList;
import java.util.List;

public class MenuHuman extends OriginalMenu{

    public MenuHuman(ConsoleUI consoleUI){
        super(consoleUI);
        this.commandList = new ArrayList<>();
        this.commandList.add(new BornHuman(consoleUI));
        this.commandList.add(new PrintFamilyTreeEvent(consoleUI));
        this.commandList.add(new SortHumanByName(consoleUI));
        this.commandList.add(new SortHumanByAge(consoleUI));
        this.commandList.add(new SortHumanById(consoleUI));
    }
}
