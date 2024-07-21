import FamilyTree.FamilyTree;
import Person.Human;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(1, "My Family Tree");
        familyTree.createHuman("John", "Doe", "Doe", LocalDate.of(1990, 1, 1), null, Human.gender.male);
        familyTree.createHuman("Jane", "Doe", "Doe", LocalDate.of(1995, 1, 1), null, Human.gender.female);
        familyTree.createChildren("genri", "joe", "doe", LocalDate.of(2000, 1, 1), null, Human.gender.male, 0, 1);
        familyTree.createChildren("sds", "joe", "doe", LocalDate.of(2000, 1, 1), null, Human.gender.male, 0, 1);
//        familyTree.printHuman(2);
        familyTree.printFamilyTree();
        familyTree.deleteHuman(3);
        familyTree.printFamilyTree();

        }
    }