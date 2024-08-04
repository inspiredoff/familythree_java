package Service;

import FamilyTree.FamilyTree;
import Person.Human;

import java.time.LocalDate;

public class FamilyTreeService {
    private FamilyTree familyTree;
    private HumanConstructor humanConstructor;
    private EventConstructor eventConstructor;

    public FamilyTreeService(FamilyTree familyTree, HumanConstructor humanConstructor, EventConstructor eventConstructor) {
        this.familyTree = familyTree;
        this.humanConstructor = humanConstructor;
        this.eventConstructor = eventConstructor;
    }

    public void BornHuman(Human father, Human mother, LocalDate BornDate, String placeName, String childFirstName) {
        Human child = humanConstructor.setName(childFirstName, father.getFamilyName(), father.getFirstName()+"ич", Human.gender.male)
                                    .setBirthDate(BornDate, placeName)
                                    .setMother(mother)
                                    .setFather(father)
                                    .build();
        familyTree.addEvent(eventConstructor.bornEvent(BornDate, placeName, father, mother, child));
    }
}
