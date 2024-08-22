package Service.constructors;

import Model.Gender;
import Model.Human.Human;
import Service.InterEntityConstructor;

import java.time.LocalDate;
import java.util.List;

public class EntityConstructor implements InterEntityConstructor<Human> {
    private Human entity;
    private int id;

    public EntityConstructor() {
        this.entity = new Human();
    }

    public EntityConstructor newEntity(Human human) {
        this.entity = human;
        return this;
    }

    public EntityConstructor newEntity(String firstName, String lastName, String familyName, Gender gender, int familyTreeId) {
        this.entity = new Human();
        setName(firstName, lastName, familyName, gender, familyTreeId);
        return this;
    }


    public EntityConstructor setName(String firstName, String lastName, String familyName, Gender gender, int familyTreeid) {
        entity.setId(id++);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setGender(gender);
        entity.setFamilyName(familyName);
        entity.setFamilyTreeId(familyTreeid);
        return this;
    }

    public EntityConstructor setParent(Human father, Human mother) {
        entity.setFather(father);
        entity.setMother(mother);
        return this;
    }

    public EntityConstructor setSpouce(Human spouce) {
        entity.setSpouse(spouce);
        return this;
    }

    public EntityConstructor setBirthDate(LocalDate birthDate) {
        entity.setBirthDate(birthDate);
        return this;
    }

    public EntityConstructor setDeathDate(LocalDate deathDate) {
        entity.setDeathDate(deathDate);
        return this;
    }

    public EntityConstructor setChildren(Human children) {
        entity.setChildren(List.of(children));
        return this;
    }

    private void refresh() {
        this.entity = null;
    }

    @Override
    public Human build() {
        Human resHuman = entity;
        refresh();
        return resHuman;
    }
}
