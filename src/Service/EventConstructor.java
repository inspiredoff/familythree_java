package Service;

import Model.Event.Event;
import Model.Human.Human;

import java.time.LocalDate;
import java.util.List;

public interface EventConstructor {

    Event newEvent(String event_name, LocalDate event_date, String placeName, int familyTree_id, List<Human> persons);

    Event deadEvent(LocalDate event_date, String placeName, int familyTree_id, Human person);

    Event bornEvent(LocalDate event_date, String placeName, int familyTree_id, Human... humans);

    Event wendingEvent(LocalDate event_date, String placeName, int familyTree_id, Human... person);

    void updateEvent(Event event, String eventName, LocalDate eventDate, String placeName, Human... persons);
}
