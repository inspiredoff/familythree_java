package Service;

import java.util.ArrayList;
import java.util.List;

import Model.Entity;
import Model.OriginalDatabase;

public class DataBaseService<T extends OriginalDatabase<Entity>> {
    private T db;
    private List<T> objectList;

    public DataBaseService (T db){
        this.db = db;
        this.objectList = new ArrayList<>();
        objectList.add(db);
    }

    public void add(Entity entity){
        db.addEntity(entity);
    }

    public Entity getById(int Id){
        return db.getById(Id);
    }

    public void printHumanInFamilyTree(){
        for (Entity entity : db.getObjectList()) {
            System.out.println(entity);            
        }
    }

    public void removeEntity(){

    }

    public T getDbById(int id){
        for (T t : objectList) {
            if (t.) {
                
            }
        }
        return db.getObjectList();
    }

    public List<T> getAlldb(){
        return List<db>;
    }


    




}
