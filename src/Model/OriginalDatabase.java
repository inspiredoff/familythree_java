package Model;

import java.util.ArrayList;
import java.util.List;


public abstract class OriginalDatabase<T extends Entity> {
    private int id;
    protected List<T> objectList;

    public OriginalDatabase(int id) {
        this.id = id;
        this.objectList = new ArrayList<>();
    }

    public abstract String getDatabaseName();


    public List<T> getObjectList() {
        return objectList;
    }

    public T getById(int id) {
        for (T t : objectList) {
            if (t.getId() == id) {
                return t;
            }
        }
        System.out.println("Human in database not Found");
        return null;
    }

    public void removeById(int id) {
        objectList.removeIf(obj -> obj.getId() == id);
    }

    public void addEntity(T model) {
        objectList.add(model);
    }
}
