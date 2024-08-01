package Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Event.Event;

public class HumanBuilder implements HumanBuilderInterface {
    private int id;
    private String first_name;
    private String last_name;
    private String family_name;
    private LocalDate birth_date;
    private LocalDate death_date;
    private Human.gender gender;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human> child;
    private List<Event> events = new ArrayList<>();


    
    @Override
    public HumanBuilderInterface setId() {
        this.id++;
        return this;
    }

    @Override
    public HumanBuilderInterface setFirstName(String first_name) {
        this.first_name = first_name;
        return this;
    }

    @Override
    public HumanBuilderInterface setLastName(String last_name) {
        this.last_name = last_name;
        return this;
    }

    @Override
    public HumanBuilderInterface setFamilyName(String family_name) {
        this.family_name = family_name;
        return this;
    }

    @Override
    public HumanBuilderInterface setGender(Human.gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public HumanBuilderInterface setBirthDate(LocalDate birth_date) {
        this.birth_date = birth_date;
        return this;
    }

    @Override
    public HumanBuilderInterface setDeathDate(LocalDate death_date) {
        this.death_date = death_date;
        return this;
    }

    @Override
    public HumanBuilderInterface setFather(Human father) {
        this.father = father;
        return this;
    }

    @Override
    public HumanBuilderInterface setMother(Human mother) {
        this.mother = mother;
        return this;
    }

    @Override
    public HumanBuilderInterface setSpouse(Human spouse) {
        this.spouse = spouse;
        return this;
    }

    @Override
    public HumanBuilderInterface setChildren(Human...children) {
        this.child = List.of(children);
        return this;
    }


    @Override
    public HumanBuilderInterface setEvent(Event event) {
        this.events.add(event);
        return this;
    }

    @Override
    public Human build() {
        Human human = new Human(
            first_name,
            last_name,
            family_name,
            birth_date,
            death_date,
            gender,
            father,
            mother,
            spouse,
            child
        ); 
        human.setEvents(events);
        human.setHumanId(id);
        return human;
    }
}
