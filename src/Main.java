import Person.Human;
import Service.Service;

import java.time.LocalDate;

import FamilyTree.FamilyTree;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        FamilyTree familyTree = service.loadFamilyTree("test.txt");
        System.out.println(familyTree);
}
}