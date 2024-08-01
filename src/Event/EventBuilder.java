package Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Person.Human;
import Place.Place;

public class EventBuilder implements EventBuilderInterface{

    private int id;
    private String eventName;
    private List<Human> persons;
    private LocalDate eventDate;
    private Place place;

    public EventBuilder(){
        this.persons = new ArrayList<>();
    }

    @Override
    public EventBuilderInterface setEventId() {
        this.id++;
        return this;
    }

    @Override
    public EventBuilderInterface setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    @Override
    public EventBuilderInterface setPersons(List<Human> persons) {
        this.persons.addAll(persons);
        return this;
    }

    @Override
    public EventBuilderInterface setEventDate(LocalDate date) {
        this.eventDate = date;
        return this;
    }

    @Override
    public EventBuilderInterface setPlace(Place place) {
        this.place = place;
        return this;
    }

    @Override
    public Event build() {
        Event event = new Event(eventName, eventDate, place, persons);
        event.setEvent_id(id);
        return event;
    }


}
