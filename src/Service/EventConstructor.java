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

    public void updateEvent(Event event, String eventName, LocalDate eventDate, String placeName, Human...persons) {
        if (eventName != null) event.setEvent_name(eventName);
        if (eventDate != null) event.setEvent_date(eventDate);
        if (placeName != null) event.setPlace(new Place(placeId++, placeName));
        if (persons != null) event.setPerson(persons);
    }
    }
