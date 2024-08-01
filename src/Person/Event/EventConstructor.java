package Person.Event;

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
}
