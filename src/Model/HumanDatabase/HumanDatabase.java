package Model.HumanDatabase;

import Model.OriginalDatabase;
import Model.Human.Human;
import Service.Comparator.ComparatorHumanByAge;
import Service.Comparator.ComparatorHumanById;
import Service.Comparator.ComparatorHumanByName;

import java.io.Serializable;
import java.util.List;


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

    public void sortHumanByName(){
        this.objectList.sort(new ComparatorHumanByName());
    }

    public void sortHumanByAge(){
        this.objectList.sort(new ComparatorHumanByAge());
    }

    public void sortHumanById(){
        this.objectList.sort(new ComparatorHumanById() );
    }
}

