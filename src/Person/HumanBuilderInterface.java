package Person;

import java.time.LocalDate;

public interface HumanBuilderInterface {
    public HumanBuilderInterface set_id();
    public HumanBuilderInterface set_first_name(String first_name);
    public HumanBuilderInterface set_last_name(String last_name);
    public HumanBuilderInterface set_gender(Human.gender gender);
    public HumanBuilderInterface set_birth_date(LocalDate birth_date);
    public HumanBuilderInterface set_death_date(LocalDate death_date);
    public HumanBuilderInterface set_family_name(String family_name);
    public HumanBuilderInterface set_father(Human father);
    public HumanBuilderInterface set_mother(Human mother);
    public HumanBuilderInterface set_spouse(Human spouse);

    public HumanBuilderInterface set_children(Human... children);

    public Human build();
}
