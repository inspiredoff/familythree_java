package view.Menu;

import view.Command.*;
import view.ConsoleUI;
import view.OriginalMenu;

import java.util.ArrayList;

public class MenuFamilytree extends OriginalMenu {

    public MenuFamilytree(ConsoleUI consoleUI){
        super(consoleUI);
        this.commandList = new ArrayList<>();
        this.commandList.add(new BornHuman(consoleUI));
        this.commandList.add(new PrintFamilyTreeEvent(consoleUI));
        this.commandList.add(new PrintFamilyTreeHuman(consoleUI));
        this.commandList.add(new PrintHuman(consoleUI));
        this.commandList.add(new PrintEvent(consoleUI));
        this.commandList.add(new SortHumanByName(consoleUI));
        this.commandList.add(new SortHumanByAge(consoleUI));
        this.commandList.add(new SortHumanById(consoleUI));
    }
}
