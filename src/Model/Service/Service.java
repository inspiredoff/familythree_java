package Model.Service;

import Model.Filehandler.FileHandler;
import Model.Models.Event.Event;
import Model.Models.Gender;
import Model.Models.Human.Human;
import Model.Service.EventDatabase.EventDatabase;
import Model.Service.HumanDatabase.HumanDatabase;
import Model.Service.constructors.EventConstructor;
import Model.Service.constructors.PersonConstructor;

import java.time.LocalDate;

public class Service {

    private OriginalDatabase<Human> humanDb;
    private OriginalDatabase<Event> eventDb;
    private int familyTreeid;
    private InterPersonConstructor<Human> humanConstructor;
    private InterEventConstructor eventConstructor;

    public Service() {
        this.humanConstructor = new PersonConstructor();
        this.eventConstructor = new EventConstructor();
        this.humanDb = new HumanDatabase();
        this.eventDb = new EventDatabase();
    }

// create FamilyTree
//    public void setFamilyTree(int familyTreeId)
//    {
//        this.humanDb.getFamilyTree(familyTreeId);
//
//    }
public void createNewTree() {
    this.familyTreeid++;
    }


//createHuman


    public void bornHuman(String firstName, String lastName, String familyName, LocalDate birthDate, String placeName, Gender gender) {
        Human human = humanConstructor.newEntity(firstName, lastName, familyName, gender, this.familyTreeid)
                                .setBirthDate(birthDate)
                                .build();
        Event event = eventConstructor.bornEvent(birthDate, placeName, this.familyTreeid, human);
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
//         System.out.println(familyTreeService.getBornEventByHuman(humanId));
//         this.eventConstructor.updateEvent(familyTreeService.getBornEventByHuman(humanId), null, null, null, father, mother);
    }

    public void wendingHuman(int wideId, int husbandId, LocalDate wendingDate, String placeName) {
        Human wife = (Human) this.humanDb.getById(wideId);
        Human husband = (Human) this.humanDb.getById(husbandId);
        Event event = this.eventConstructor.wendingEvent(wendingDate, placeName, this.familyTreeid, wife, husband);
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

    public void printFamilyTreeHuman() {
        System.out.println(this.humanDb.getFamilyTree(familyTreeid));
    }

    public void printEventInFamilyTree() {
        System.out.println(this.eventDb.getFamilyTree(familyTreeid));
    }

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
    public void saveFamilyTree(String filePatchHumandb, String filePatchEventdb, Integer familyTreeId) {
        HumanDatabase humanDatabase = (HumanDatabase) this.humanDb.getFamilyTree(familyTreeId);
        EventDatabase eventDatabase = (EventDatabase) this.eventDb.getFamilyTree(familyTreeId);
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFilePath(filePatchHumandb);
        fileHandler.write(humanDatabase);
        FileHandler fileHandlerEvent = new FileHandler();
        fileHandlerEvent.setFilePath(filePatchEventdb);
        fileHandlerEvent.write(eventDatabase);
    }

    public void loadFamilyTree (String filePatch){
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFilePath(filePatch);
        fileHandler.read();
    }
}
