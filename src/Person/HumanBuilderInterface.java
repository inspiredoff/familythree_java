package Person;

import java.time.LocalDate;

import Event.Event;

public interface HumanBuilderInterface {
    

    public HumanBuilderInterface setId();
    public HumanBuilderInterface setFirstName(String first_name);
    public HumanBuilderInterface setLastName(String last_name);
    public HumanBuilderInterface setFamilyName(String family_name);
    public HumanBuilderInterface setGender(Human.gender gender);
    public HumanBuilderInterface setBirthDate(LocalDate birth_date);
    public HumanBuilderInterface setDeathDate(LocalDate death_date);
    public HumanBuilderInterface setEvent(Event event);
    public HumanBuilderInterface setFather(Human father);
    public HumanBuilderInterface setMother(Human mother);
    public HumanBuilderInterface setSpouse(Human spouse);
    public HumanBuilderInterface setChildren(Human... children);
    public Human build();
}
