package Service;

import Filehandler.FileHandler;
import Model.Event.Event;
import Model.Human.Human;
import Model.OriginalDatabase;
import Service.EventDatabase.EventDatabase;
import Service.HumanDatabase.HumanDatabase;
import Service.constructors.EntityConstructor;
import Service.constructors.EventConstructor;

import java.time.LocalDate;

public class Service {

    private OriginalDatabase humanDb;
    private OriginalDatabase eventDb;
    private InterEntityConstructor humanConstructor;
    private InterEventConstructor eventConstructor;

    public Service() {
        this.humanConstructor = new EntityConstructor();
        this.eventConstructor = new EventConstructor();
        this.humanDb = new HumanDatabase(0);
        this.eventDb = new EventDatabase(0);
    }

// create FamilyTree
    public void setFamilyTree(int familyTreeId) {
        this.familyTreeService.setFamilyTree(familyTreeId);
    }
    public void createNewTree(String FamilyTreeeName) {
        this.familyTreeService.createFamilyTree(FamilyTreeeName);
    }


//createHuman

    

    public void bornHuman(String firstName, String lastName, String familyName, LocalDate birthDate, String placeName, Human.gender gender, int familyTreeId) {
        Human human = humanConstructor.newEntity(firstName, lastName, familyName, gender, familyTreeId)
                                .setBirthDate(birthDate)
                                .build();
        Event event = eventConstructor.bornEvent(birthDate, placeName, 0, human);
        this.humanDb.addEntity(human);
        this.eventDb.addEntity(event);
    }

    public void setParent(int humanId, int fatherId, int motherId) {
        Human father = (Human) this.humanDb.getById(fatherId);
        Human mother = (Human) this.humanDb.getById(motherId);
        Human human = (Human) this.humanDb.getById(humanId);
        this.humanConstructor.newEntity(human)
                            .setParent(father, mother)
                            .build();
        this.humanConstructor.newEntity(father).setChildren(human).build();
        this.humanConstructor.newEntity(mother).setChildren(human).build();
        // System.out.println(familyTreeService.getBornEventByHuman(humanId));
        // this.eventConstructor.updateEvent(familyTreeService.getBornEventByHuman(humanId), null, null, null, father, mother);
    }

    public void wendingHuman(int wideId, int husbandId, LocalDate wendingDate, String placeName, int familyTreeId){
        Human wife = (Human) this.humanDb.getById(wideId);
        Human husband = (Human) this.humanDb.getById(husbandId);
        Event event = this.eventConstructor.wendingEvent(wendingDate, placeName,familyTreeId, wife, husband);
        this.eventDb.addEntity(event);
    }

    public void deadHuman(int humanId, LocalDate deathDate, String placeName, int familyTreeId){
        Human human = (Human) this.humanDb.getById(humanId);
        this.humanConstructor.newEntity(human).setDeathDate(deathDate).build();
        Event event = eventConstructor.deadEvent(deathDate, placeName,familyTreeId, human);
        this.eventDb.addEntity(event);
    }

    public void updateEvent(int eventId, String event_name, LocalDate event_date, String placeName){
        this.eventConstructor.updateEvent((Event) this.eventDb.getById(eventId), event_name, event_date, placeName);
    }

// remove


// print

    // public void printFamilyTreeHuman(){
    //     this.familyTreeService.printHumanInFamilyTree();
    // }

    // public void printEventInFamilyTree(){
    //    this.familyTreeService.printEventInFamilyTree();
    // }

// sort
    public void sortHumanByName() {
        ((HumanDatabase) this.humanDb).sortHumanByName();
    }

    public void sortHumanByAge() {
        ((HumanDatabase) this.humanDb).sortHumanByAge();
    }

    public void sortHumanById() {
        this.humanDb.sortHumanById();
    }
// save load
    public void saveFamilyTree(String filePatch, Integer familyTreeId) {
        HumanDatabase familyTree = (HumanDatabase) this.humanDb.getFamilyTree(familyTreeId);
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFilePath(filePatch);
        fileHandler.write(familyTree);
    }

    public static HumanDatabase loadFamilyTree (String filePatch){
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFilePath(filePatch);
        return (HumanDatabase) fileHandler.read();
    }
}
