import FamilyTree.FamilyTree;
import Person.Human;
import Service.HumanConstructor;
import Service.Service;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.bornHuman("Artem", "Vadimovich", "Chernov", LocalDate.of(1995, 22, 02), "Dzerhinsk", null, null);
}
}