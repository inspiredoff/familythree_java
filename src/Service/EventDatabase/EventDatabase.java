package Service.EventDatabase;

import Model.Event.Event;
import Service.OriginalDatabase;

public class EventDatabase extends OriginalDatabase<Event> {

    public EventDatabase() {
        super();
    }

    @Override
    public String getDatabaseName() {
        return "event-database";
    }

}
