package Service.EventDatabase;

import Model.Event.Event;
import Model.OriginalDatabase;

public class EventDatabase extends OriginalDatabase<Event> {
    
    public EventDatabase(int id) {
        super(id);
    }

    @Override
    public String getDatabaseName() {
        return "human-database";
    }

}
