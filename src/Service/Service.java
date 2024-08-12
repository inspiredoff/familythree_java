package Service;

import FamilyTree.FamilyTree;
import Person.Human;
import Person.Event.Event;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private EventConstructor eventConstructor;
    private FamilyTreeConstructor familyTreeConstructor;
    private HumanConstructor humanConstructor;

    public Service() {
        this.eventConstructor = new EventConstructor();
        this.humanConstructor = new HumanConstructor();
    }

    public void createNewTree(String FamilyTreeeName) {
        this.familyTreeConstructor.createFamilyTree(FamilyTreeeName);
    }

    public void bornHuman(String firstName, String lastName, String familyName, LocalDate birthDate, String placeName, Human father, Human mother){
        Human human = humanConstructor.newHuman(firstName, lastName, familyName)
                                .humanSetBirthDate(birthDate)
                                .build();
        Event event = eventConstructor.bornEvent(birthDate, placeName, father, mother, human);
        this.familyTreeConstructor.addHuman(human);
        this.familyTreeConstructor.addEvent(event);
    }

    public void setParent(Human human, Human father, Human mother){
        this.humanConstructor.newHuman(human)
                            .humanSetParent(father, mother)
                            .build();
    }

    public void wendingHuman(Human wife, Human husband, LocalDate wendingDate, String placeName){
        Event event = this.eventConstructor.wendingEvent(wendingDate, placeName, wife, husband);
        this.familyTreeConstructor.addEvent(event);
    }

    public void deadHuman(Human human, LocalDate deathDate, String placeName ){
        this.humanConstructor.newHuman(human).humanSetDeathDate(deathDate).build();
        Event event = eventConstructor.deadEvent(deathDate, placeName, human);
        this.familyTreeConstructor.addEvent(event);
    }

    public void printFamilyTreeHuman(){
        this.familyTreeConstructor.printHumanInFamilyTree();
    }

    public void printEventInFamilyTree(){
        this.familyTreeConstructor.printEventInFamilyTree();
    }
}
