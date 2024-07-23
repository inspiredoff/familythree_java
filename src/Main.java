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
        familyTree.createHuman(
            "Артем",
                "Чернов",
                "Вадимович",
                LocalDate.of(1995, 2, 22),
                null,
                Human.gender.male
        );
        familyTree.createHuman(
                "Полина",
                "Чернова",
                "Александровна",
                LocalDate.of(1995, 4, 9),
                null,
                Human.gender.female
        );
        familyTree.createChildren(
                "Матвей",
                "Чернов",
                "Артемович",
                LocalDate.of(2022, 12, 28),
                null,
                Human.gender.male,
                0,
                1
        );
        familyTree.createHuman(
                "Александр",
                "Костыгин",
                "Витальевич",
                LocalDate.of(1967, 2, 22),
                null,
                Human.gender.male);

        familyTree.createHuman(
                "Наталья",
                "Костыгина",
                "Юрьевна",
                LocalDate.of(1957, 4, 9),
                null,
                Human.gender.female
        );
        familyTree.setParent(1, 3, 4);

        familyTree.printFamilyTree();

        }
    }