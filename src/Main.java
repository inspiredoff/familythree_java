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
       
       HumanBuilder humanBuilder = new HumanBuilder();
       EventBuilder eventBuilder = new EventBuilder();
       Director director = new Director(humanBuilder, eventBuilder);
       director.createHuman(humanBuilder, "Artem", "chernov", "vadimovich", gender.male);
       director.createBirthDate(humanBuilder, LocalDate.of(1995, 02, 22), "Dzerzhinsk");
       director.getHuman(humanBuilder);
       HumanBuilder humanBuilder2 = new HumanBuilder();
       director.createHuman(humanBuilder2, "sdsd", "sdsd", "awrf", gender.female);
       director.createBirthDate(humanBuilder2, LocalDate.of(1234, 05, 23), "sdac");
       Human human2 = humanBuilder2.build();
       Human human = humanBuilder.build();
       System.out.println(human);
       System.out.println(human2);
    }
}