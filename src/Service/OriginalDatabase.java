package Service;

import Model.Entity;

import java.util.ArrayList;
import java.util.List;


public abstract class OriginalDatabase<T extends Entity> {
    protected List<T> objectList;

    public OriginalDatabase() {
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

    public List<T> getFamilyTree(int familyTreeId) {
        List<T> list = new ArrayList<>();
        for (T t : objectList) {
            if (t.getFamilyTreeId() == familyTreeId) {
                list.add(t);
            }
        }
        return list;
    }

    public void sortHumanById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortHumanById'");
    }
    
}
