package Model.Service.EventDatabase;

import Model.Models.Event.Event;
import Model.Service.OriginalDatabase;

public class EventDatabase extends OriginalDatabase<Event> {

    public EventDatabase() {
        super();
    }

    @Override
    public String getDatabaseName() {
        return "event-database";
    }

}
