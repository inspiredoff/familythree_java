import FamilyTree.FamilyTree;
import Person.Human;
import Service.HumanConstructor;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(1, "Chernovi");
        HumanConstructor humanConstructor = new HumanConstructor(familyTree);
        Human human = humanConstructor
                .setName("Ivan", "Ivanov", "Ivanovich", Human.gender.male)
                .setBirthDate(LocalDate.of(1990, 1, 1), "Moscow")
                .setDeathDate(LocalDate.of(1995, 1, 1), "Moscow")
                .build();
        System.out.println(human);
        familyTree.getEvent(0);
    }
}