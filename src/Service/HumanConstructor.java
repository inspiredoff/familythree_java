package Service;

import Model.Human.Human;

import java.time.LocalDate;

public interface HumanConstructor {

    public HumanConstructor newHuman(String firstName, String lastName, String familyName, Human.gender gender, int familyTreeId);

    public HumanConstructor humanSetName(String firstName, String lastName, String familyName, Human.gender gender, int familyTreeid);

    public HumanConstructor humanSetParent(Human father, Human mother);

    public HumanConstructor humanSetSpouce(Human spouce);

    public HumanConstructor humanSetBirthDate(LocalDate birthDate);

    public HumanConstructor humanSetDeathDate(LocalDate deathDate);

    public HumanConstructor setChildren(Human children);

    public Human build();
}
