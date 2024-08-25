import Model.Models.Gender;
import Model.Service.Service;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.createNewTree();
        service.bornHuman("Boris", "Test", "Test", LocalDate.of(1980, 1, 1), "Test", Gender.male);
        service.bornHuman("Anna", "Test", "Test", LocalDate.of(1990, 1, 1), "Test", Gender.female);
        service.wendingHuman(0, 1, LocalDate.of(2000, 1, 1), "placeWending");
        service.bornHuman("Nikita", "Test", "Test", LocalDate.of(2001, 1, 1), "Test", Gender.male);
        service.setParent(2, 0, 1);

        service.sortHumanByName();
        service.printFamilyTreeHuman();
        service.sortHumanByAge();
        service.printFamilyTreeHuman();
}
}