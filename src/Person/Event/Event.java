package Person.Event;

import Person.Human;
import Person.Place.Place;

import java.time.LocalDate;
import java.util.List;

public class Event {

    private int event_id;
    private String event_name;
    private List<Human> persons;
    private LocalDate event_date;
    private Place place;

    public Event(int eventId,String event_name, LocalDate event_date, Place place, List<Human> persons) {
        this.event_id = eventId;
        this.event_name = event_name;
        this.event_date = event_date;
        this.persons = persons;
        this.place = place;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
        this.event_date = event_date;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void setPerson(Human...person){
        this.persons.addAll(persons);
    }

    public List<Human> getPersons(){
        return this.persons;
    }

    @Override
    public String toString() {
        return "Event [event_id=" + event_id + ", event_name=" + event_name + ", persons=" + persons + ", event_date="
                + event_date + ", place=" + place + "]";
    }

    
}
