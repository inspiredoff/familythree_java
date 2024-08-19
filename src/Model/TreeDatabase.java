package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class TreeDatabase {
    private int id;
    private String name;
    private BaseModel model;
    private List<BaseModel> objectList;

    public TreeDatabase(int id, String name) {
        this.id = id;
        this.name = name;
        this.objectList = new ArrayList<>();
    }

    public List<BaseModel> getObjectList() {
        return objectList;
    }

    public BaseModel getObject(int id) {
        for (BaseModel model : objectList) {
            if (model.getId() == id) {
                return model;
            }
        }
        return null;
    }

    public void remove(int id) {
        for (BaseModel model : objectList) {
            if (model.getId() == id) {
                objectList.remove(model);
            }
        }

    }

    public void add(BaseModel model) {
        objectList.add(model);
    }
}
