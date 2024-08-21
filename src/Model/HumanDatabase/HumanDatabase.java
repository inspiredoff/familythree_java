package Model.HumanDatabase;

import Model.OriginalDatabase;
import Model.Event.Event;
import Model.Human.Human;

import java.io.Serializable;


public class HumanDatabase extends OriginalDatabase<Human> implements Serializable {


    public HumanDatabase(int id) {
        super(id);
    }

    @Override
    public String getDatabaseName() {
        return "human-database";
    }
    
    public void removeByName(String name) {
        objectList.removeIf(obj-> obj.getFirstName().equals(name));
    }
    }

