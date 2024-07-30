package Person;

import java.time.LocalDate;

public interface Builder {
    public Builder set_id(int id);
    public Builder set_first_name(String first_name);
    public Builder set_last_name(String last_name);
    public Builder set_gender(Human.gender gender);
    public Builder set_birth_date(LocalDate birth_date);
    public Builder set_death_date(LocalDate death_date);
    public Builder set_family_name(String family_name);
    public Builder set_father(Human father);
    public Builder set_mother(Human mother);
    public Builder set_spouse(Human spouse);

    public Builder set_children(Human... children);

    public Human build();
}
