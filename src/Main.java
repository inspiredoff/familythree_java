import Person.Human;
import Service.Service;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.createNewTree("Chernovs");
        service.bornHuman("Artem", "Vadimovich", "Chernov", LocalDate.of(1995, 2, 2), "Dzerhinsk", Human.gender.male);
        service.bornHuman("Dmitry", "Vadimovich", "Chernov", LocalDate.of(1995, 2, 2), "Dzerhinsk", Human.gender.male);
        service.bornHuman("Sergey", "Vadimovich", "Chernov", LocalDate.of(1995, 2, 2), "Dzerhinsk", Human.gender.male);
        service.setParent(0, 1, 2);
        service.printFamilyTreeHuman();
        service.printEventInFamilyTree();
}
}