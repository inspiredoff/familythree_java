package Service;

import FamilyTree.FamilyTree;
import Person.Human;

import java.time.LocalDate;
import java.util.List;

public class HumanConstructor {
    private Human human;
    private int id;
    private FamilyTree familyTree;
    private EventConstructor event = new EventConstructor();

    public HumanConstructor(FamilyTree familyTree) {
        this.familyTree = familyTree;
        this.human = new Human();
        this.familyTree.addHuman(human);
        human.setHumanId(id++);
    }

    public HumanConstructor(Human human, FamilyTree familyTree) {
        this.human = human;
        this.familyTree = familyTree;
        if (familyTree.getHuman(human.getHumanId()) == null) {
            this.familyTree.addHuman(human);
        }
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

    public HumanConstructor setBirthDate(LocalDate birth_date, String place) {
        human.setBirthDate(birth_date);
        familyTree.addEvent(event.bornEvent(birth_date, place, human));
        return this;
    }

    public HumanConstructor setDeathDate(LocalDate death_date, String place) {
        human.setDeathDate(death_date);
        familyTree.addEvent(event.deadEvent(death_date, place, human));
        return this;
    }

    public HumanConstructor setFather(Human father) {
        human.setFather(father);
        familyTree.addEvent(event.bornChildEvent(human.getBirthDate(),
                        human.getEvents().getFirst().getPlace().getPlaceName(),
                        father, human));
        return this;
    }

    public HumanConstructor setMother(Human mother) {
        human.setMother(mother);
        familyTree.addEvent(event.bornChildEvent(human.getBirthDate(),
                human.getEvents().getFirst().getPlace().getPlaceName(),
                mother, human));
        return this;
    }

    public HumanConstructor setSpouse(Human spouse, String wendingPlace, LocalDate wendingDate) {
        human.setSpouse(spouse);
        for (Human human : List.of(human, spouse)) {
        familyTree.addEvent(event.wendingEvent(wendingDate, wendingPlace, human, spouse));//TODO поменять принцип вызова метода
        }
        return this;
    }

    public HumanConstructor addChild(Human...child) {
        human.setChildren(List.of(child));
        familyTree.addEvent(event.bornChildEvent( human.getBirthDate(),
                human.getEvents().getFirst().getPlace().getPlaceName(), human, (Human) List.of(child)));//TODO поменять принцип добавления детей
        return this;

    }
    public Human build() {
        return human;
    }
}
