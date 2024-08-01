import java.time.LocalDate;

import Event.EventBuilder;
import Person.Human;
import Person.HumanBuilder;
import Person.Human.gender;
import Service.Director;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       
        HumanBuilder humanbuilder = new HumanBuilder();
        EventBuilder eventBuilder = new EventBuilder();
        Director director = new Director(humanbuilder, eventBuilder);
        Human human = director.createHuman(
                "Artem",
                "Chernov",
                "Vadimovich",
                LocalDate.of(1995, 02, 22),
                null,
                null,
                null,
                gender.male,
                null,
                null,
                null,
                null,
                null);
        System.out.println(human.toString());
        }
    }