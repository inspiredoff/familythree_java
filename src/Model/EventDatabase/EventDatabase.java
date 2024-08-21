package Model.EventDatabase;
import Model.OriginalDatabase;
import Model.Event.Event;

import java.util.List;

public class EventDatabase extends OriginalDatabase<Event> {
    
    public EventDatabase(int id) {
        super(id);
    }

    @Override
    public String getDatabaseName() {
        return "human-database";
    }

}
