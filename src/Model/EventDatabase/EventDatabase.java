package Model.EventDatabase;

import Model.BaseModel;
import Model.TreeDatabase;

import java.util.List;

public class EventDatabase extends TreeDatabase {
    @Override
    public List<BaseModel> getObjectList() {
        return super.getObjectList();
    }

    @Override
    public BaseModel getObject(int id) {
        return super.getObject(id);
    }

    @Override
    public void remove(int id) {
        super.remove(id);
    }

    @Override
    public void add(BaseModel model) {
        super.add(model);
    }

    public EventDatabase(int id, String name) {
        super(id, name);
    }
}
