package Event;

import java.time.LocalDate;
import java.util.List;

import Person.Human;
import Place.Place;

public interface EventBuilderInterface {

    public EventBuilderInterface setEventId();
    public EventBuilderInterface setEventName(String Name);
    public EventBuilderInterface setPersons(List<Human>persons);
    public EventBuilderInterface setEventDate(LocalDate date);
    public EventBuilderInterface setPlace(Place place);
    public Event build();


}
