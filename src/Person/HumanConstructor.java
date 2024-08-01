package Person;

import Person.Event.EventConstructor;

import java.time.LocalDate;
import java.util.List;

public class HumanConstructor {
    private Human human;
    private int id;
    private EventConstructor event = new EventConstructor();

    public HumanConstructor() {
        this.human = new Human();
    }

    public HumanConstructor(Human human) {
        this.human = human;
    }

    public HumanConstructor setName(String first_name, String last_name, String family_name, Human.gender gender) {
        human.setHumanId(id++);
        human.setFirstName(first_name);
        human.setLastName(last_name);
        human.setFamilyName(family_name);
        human.setGender(gender);
        return this;
    }

    public HumanConstructor setBirthDate(LocalDate birth_date, String place) {
        human.setBirthDate(birth_date);
        human.setEvents(List.of(event.newEvent("born", birth_date, place, List.of(human))));
        return this;
    }

    public HumanConstructor setDeathDate(LocalDate death_date, String place) {
        human.setDeathDate(death_date);
        human.setEvents(List.of(event.newEvent("died", death_date, place, List.of(human))));
        return this;
    }

    public HumanConstructor setFather(Human father) {
        human.setFather(father);
        father.setEvents(List.of(event.newEvent("bornchild", human.getBirthDate(), human.getEvents().getFirst().getPlace().getPlaceName(), List.of(father, human))));
        return this;
    }

    public HumanConstructor setMother(Human mother) {
        human.setMother(mother);
        mother.setEvents(List.of(event.newEvent("bornchild", human.getBirthDate(), human.getEvents().getFirst().getPlace().getPlaceName(), List.of(mother, human))));
        return this;
    }

    public HumanConstructor setSpouse(Human spouse, String wendingPlace, LocalDate wendingDate) {
        human.setSpouse(spouse);
        for (Human human : List.of(human, spouse)) {
        human.setEvents(List.of(event.newEvent("wending", wendingDate, wendingPlace, List.of(human, spouse))));
        }
        return this;
    }

    public HumanConstructor addChild(Human...child) {
        human.setChildren(List.of(child));
        human.setEvents(List.of(event.newEvent("bornchild",
                human.getBirthDate(),
                human.getEvents().getFirst().getPlace().getPlaceName(), List.of(human))));
        return this;
    }
    public Human build() {
        return human;
    }
}
