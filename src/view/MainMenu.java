package view;

import view.Command.CreateNewTree;
import view.Command.LoadFamilyTree;
import view.Command.SaveFamilyTree;

public class MainMenu extends OriginalMenu {

    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        this.commandList.add(new CreateNewTree(consoleUI));
        this.commandList.add(new SaveFamilyTree(consoleUI));
        this.commandList.add(new LoadFamilyTree(consoleUI));
    }
}



