package Service;

import Model.Human.Human;

import java.time.LocalDate;

public interface InterEntityConstructor {

    public InterEntityConstructor newEntity (Human human);

    public InterEntityConstructor newEntity (String firstName, String lastName, String familyName, Human.gender gender, int familyTreeId);

    public InterEntityConstructor setName(String firstName, String lastName, String familyName, Human.gender gender, int familyTreeid);

    public InterEntityConstructor setParent(Human father, Human mother);

    public InterEntityConstructor setSpouce(Human spouce);

    public InterEntityConstructor setBirthDate(LocalDate birthDate);

    public InterEntityConstructor setDeathDate(LocalDate deathDate);

    public InterEntityConstructor setChildren(Human children);

    public Human build();
}

