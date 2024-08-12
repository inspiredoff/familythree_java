package Service;

import Person.Event.Event;
import Person.Human;
import Person.Place.Place;

import java.time.LocalDate;
import java.util.List;

public class EventConstructor {
    private int id;
    private int placeId;

    public EventConstructor() {
    }

    public Event newEvent (String event_name, LocalDate event_date, String placeName, List<Human> persons) {
        return new Event(id++, event_name, event_date, new Place(placeId++, placeName), persons);
    }

    public Event deadEvent (LocalDate event_date, String placeName,Human person) {
        return newEvent("died", event_date, placeName, List.of(person));
    }

    public Event bornEvent (LocalDate event_date, String placeName, Human...humans) {
        return newEvent("bornchild", event_date, placeName, List.of(humans));
    }

    public Event wendingEvent (LocalDate event_date, String placeName, Human...person) {
        return newEvent("wending", event_date, placeName, List.of(person));
    }
}
