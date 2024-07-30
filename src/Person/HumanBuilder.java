package Person;

import java.time.LocalDate;
import java.util.List;

public class HumanBuilder implements Builder {
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


    @Override
    public Builder set_id(int id) {
        this.id = id;
        return this;
    }

    @Override
    public Builder set_first_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    @Override
    public Builder set_last_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    @Override
    public Builder set_family_name(String family_name) {
        this.family_name = family_name;
        return this;
    }

    @Override
    public Builder set_gender(Human.gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public Builder set_birth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
        return this;
    }

    @Override
    public Builder set_death_date(LocalDate death_date) {
        this.death_date = death_date;
        return this;
    }

    @Override
    public Builder set_father(Human father) {
        this.father = father;
        return this;
    }

    @Override
    public Builder set_mother(Human mother) {
        this.mother = mother;
        return this;
    }

    @Override
    public Builder set_spouse(Human spouse) {
        this.spouse = spouse;
        return this;
    }

    @Override
    public Builder set_children(Human...children) {
        this.child = List.of(children);
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
        human.setHumanId(id);
        return human;
    }
}
