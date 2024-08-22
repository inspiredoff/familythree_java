package Service.constructors;

import Model.Human.Human;
import Service.InterEntityConstructor;

import java.time.LocalDate;
import java.util.List;

public class HumanConstructor implements InterEntityConstructor {
    private Human human;
    private int id;

    public HumanConstructor() {
        this.human = new Human();
    }

    @Override
    public HumanConstructor newEntity(Human human) {
        this.human = human;
        return this;
    }

    @Override
    public HumanConstructor newEntity(String firstName, String lastName, String familyName, Human.gender gender, int familyTreeId) {
        this.human = new Human();
        setName(firstName, lastName, familyName, gender, familyTreeId);
        return this;
    }


    @Override
    public HumanConstructor setName(String firstName, String lastName, String familyName, Human.gender gender, int familyTreeid) {
        human.setHumanId(id++);
        human.setFirstName(firstName);
        human.setLastName(lastName);
        human.setGender(gender);
        human.setFamilyName(familyName);
        human.setFamilyTreeId(familyTreeid);
        return this;
    }

    @Override
    public HumanConstructor setParent(Human father, Human mother) {
        human.setFather(father);
        human.setMother(mother);
        return this;
    }

    @Override
    public HumanConstructor setSpouce(Human spouce) {
        human.setSpouse(spouce);
        return this;
    }

    @Override
    public HumanConstructor setBirthDate(LocalDate birthDate) {
        human.setBirthDate(birthDate);
        return this;
    }

    @Override
    public HumanConstructor setDeathDate(LocalDate deathDate) {
        human.setDeathDate(deathDate);
        return this;
    }

    @Override
    public HumanConstructor setChildren(Human children) {
        human.setChildren(List.of(children));
        return this;
    }

    private void refresh() {
        this.human = null;
    }

    @Override
    public Human build() {
        Human resHuman = human;
        refresh();
        return resHuman;
    }
}
