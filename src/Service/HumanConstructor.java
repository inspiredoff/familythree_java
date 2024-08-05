package Service;

import Person.Human;

import java.time.LocalDate;
import java.util.List;

public class HumanConstructor {
    private Human human;
    private int id;

    public HumanConstructor() {
        this.newHuman();
    }
    public void newHuman(){
        this.human = new Human();
        human.setHumanId(id++);
    }

    public void setHuman (Human human){
        this.human = human;
    }

    //TODO почистить класс и оставить только методы работы с людьми
    //TODO сделать работу сервиса с этим классом через интерфейс

    public HumanConstructor setName(String first_name, String last_name, String family_name, Human.gender gender) {
        human.setFirstName(first_name);
        human.setLastName(last_name);
        human.setFamilyName(family_name);
        human.setGender(gender);
        return this;
    }

    public HumanConstructor setBirthDate(LocalDate birth_date) {
        human.setBirthDate(birth_date);
        return this;
    }

    public HumanConstructor setDeathDate(LocalDate death_date) {
        human.setDeathDate(death_date);
        return this;
    }

    public HumanConstructor setParent (Human father, Human mother){
        this.setFather(father);
        this.setMother(mother);

        //TODO add proverki
        return this;
    }
    private HumanConstructor setFather(Human father) {
        human.setFather(father);
        return this;
    }

    private HumanConstructor setMother(Human mother) {
        human.setMother(mother);
        return this;
    }

    public HumanConstructor setSpouse(Human spouse) {
        human.setSpouse(spouse);
        return this;
    }

    public HumanConstructor addChild(Human...child) {
        human.setChildren(List.of(child));
        return this;
    }

    public Human build() {
        return human;
    }
}
