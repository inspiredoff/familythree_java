package Service.HumanDatabase;

import Model.Human.Human;
import Service.Comparator.ComparatorHumanByAge;
import Service.Comparator.ComparatorHumanById;
import Service.Comparator.ComparatorHumanByName;
import Service.OriginalDatabase;

import java.io.Serializable;


public class HumanDatabase extends OriginalDatabase<Human> implements Serializable {


    public HumanDatabase() {
        super();
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

