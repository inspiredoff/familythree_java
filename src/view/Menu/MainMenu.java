package view.Menu;

import view.Command.*;
import view.ConsoleUI;
import view.OriginalMenu;

public class MainMenu extends OriginalMenu {

    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        this.commandList.add(new CreateNewTree(consoleUI));
        this.commandList.add(new SetCurrentFamilyTree(consoleUI));
        this.commandList.add(new SaveFamilyTree(consoleUI));
        this.commandList.add(new LoadFamilyTree(consoleUI));
        this.commandList.add(new Exit(consoleUI));
    }
}



