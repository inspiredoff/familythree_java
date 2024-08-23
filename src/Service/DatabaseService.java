package Service;

import java.util.List;

import Model.Entity;

public class DatabaseService {
    private OriginalDatabase<Entity> db;
    private int FamilyTreeId;

    private DatabaseService(OriginalDatabase<Entity> db){
        this.db = db;
    }

    private void createNewTree(){
        this.FamilyTreeId++;
    }

    private void addEntity(Entity entity){
        this.db.addEntity(entity);
    }

    private List<Entity> getDb(){
        return db.getObjectList();
    }

    private List<Entity> getFamilyTree(int id){
        return db.getFamilyTree(id);
    }

    




}
