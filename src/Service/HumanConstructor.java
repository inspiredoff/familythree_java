package Service;

import java.time.LocalDate;
import java.util.List;

import Model.Human.Human;

public class HumanConstructor {
    private Human human;
    private int id;

    public HumanConstructor(){
        this.human = new Human();
    }

    public HumanConstructor newHuman(Human human){
        this.human = human;
        return this;
    }

    public HumanConstructor newHuman(String firstName, String lastName, String familyName, Human.gender gender){
        this.human = new Human();
        humanSetName(firstName, lastName, familyName, gender);
        return this;
    }

    public HumanConstructor humanSetName(String firstName, String lastName, String familyName, Human.gender gender){
        human.setHumanId(id++);
        human.setFirstName(firstName);
        human.setLastName(lastName);
        human.setGender(gender);
        human.setFamilyName(familyName);
        return this;
    }

    public HumanConstructor humanSetParent(Human father, Human mother){
        human.setFather(father);
        human.setMother(mother);
        return this;
    }

    public HumanConstructor humanSetSpouce(Human spouce){
        human.setSpouse(spouce);
        return this;
    }

    public HumanConstructor humanSetBirthDate(LocalDate birthDate){
        human.setBirthDate(birthDate);
        return this;
    }

    public HumanConstructor humanSetDeathDate(LocalDate deathDate){
        human.setDeathDate(deathDate);
        return this;
    }

    public HumanConstructor setChildren(Human children) {
        human.setChildren(List.of(children));
        return this;
    }

    private void refresh(){
        this.human = null;
    }

    public Human build(){
        Human resHuman = human;
        refresh();
        return resHuman;
    }
}
