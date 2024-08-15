package Service;

import FamilyTree.FamilyTree;
import Filehandler.FileHandler;
import Person.Event.Event;
import Person.Human;

import java.time.LocalDate;

public class Service {
    private EventConstructor eventConstructor;
    private FamilyTreeService familyTreeService;
    private HumanConstructor humanConstructor;

    public Service() {
        this.eventConstructor = new EventConstructor();
        this.humanConstructor = new HumanConstructor();
        this.familyTreeService = new FamilyTreeService();
    }

    public void setFamilyTree(int familyTreeId) {
        this.familyTreeService.setFamilyTree(familyTreeId);
    }
    public void createNewTree(String FamilyTreeeName) {
        this.familyTreeService.createFamilyTree(FamilyTreeeName);
    }

    public void bornHuman(String firstName, String lastName, String familyName, LocalDate birthDate, String placeName, Human.gender gender) {
        Human human = humanConstructor.newHuman(firstName, lastName, familyName, gender)
                                .humanSetBirthDate(birthDate)
                                .build();
        Event event = eventConstructor.bornEvent(birthDate, placeName, human);
        this.familyTreeService.addHuman(human);
        this.familyTreeService.addEvent(event);
    }

    public void setParent(int humanId, int fatherId, int motherId) {
        Human father = this.familyTreeService.getHuman(fatherId);
        Human mother = this.familyTreeService.getHuman(motherId);
        Human human = this.familyTreeService.getHuman(humanId);
        this.humanConstructor.newHuman(human)
                            .humanSetParent(father, mother)
                            .build();
        // this.eventConstructor.updateEvent(familyTreeService.getBornEventByHuman(humanId),null , null, null, human, father, mother);
    }

    public void wendingHuman(int wideId, int husbandId, LocalDate wendingDate, String placeName){
        Human wife = this.familyTreeService.getHuman(wideId);
        Human husband = this.familyTreeService.getHuman(husbandId);
        Event event = this.eventConstructor.wendingEvent(wendingDate, placeName, wife, husband);
        this.familyTreeService.addEvent(event);
    }

    public void deadHuman(int humanId, LocalDate deathDate, String placeName ){
        Human human = this.familyTreeService.getHuman(humanId);
        this.humanConstructor.newHuman(human).humanSetDeathDate(deathDate).build();
        Event event = eventConstructor.deadEvent(deathDate, placeName, human);
        this.familyTreeService.addEvent(event);
    }

    public void printFamilyTreeHuman(){
        this.familyTreeService.printHumanInFamilyTree();
    }

    public void printEventInFamilyTree(){
        this.familyTreeService.printEventInFamilyTree();
    }

    public void updateEvent(int eventId, String event_name, LocalDate event_date, String placeName){
        this.eventConstructor.updateEvent(this.familyTreeService.getEvent(eventId), event_name, event_date, placeName);

    }

    public void saveFamilyTree(String filePatch, Integer familyTreeId) {
        FamilyTree familyTree = this.familyTreeService.getFamilyTree(familyTreeId);
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFilePath(filePatch);
        fileHandler.write(familyTree);
    }

    public static FamilyTree loadFamilyTree (String filePatch){
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFilePath(filePatch);
        return (FamilyTree)fileHandler.read();
    }


}
