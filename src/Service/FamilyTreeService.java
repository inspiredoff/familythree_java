package Service;

import FamilyTree.FamilyTree;
import Person.Event.Event;
import Person.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeService {
    private int familyTreeId;
    private FamilyTree familyTree;
    private List<FamilyTree> listFamilyTrees;


    public FamilyTreeService() {
        this.listFamilyTrees = new ArrayList<>();

    }

    public void createFamilyTree(String FamilyTreeName){
        FamilyTree familyTree = new FamilyTree(familyTreeId++, FamilyTreeName);
        this.listFamilyTrees.add(familyTree);
        this.familyTree = familyTree;
    }

    public void addHuman(Human human){
        this.familyTree.addHuman(human);
    }

    public void addEvent(Event event){
        this.familyTree.addEvent(event);
    }

    public Event getEvent(int eventId){
        return this.familyTree.getEvent(eventId);
    }

    public Human getHuman(int humanId){
        return this.familyTree.getHuman(humanId);
    }

    public void printHumanInFamilyTree(){
        for (Human human: this.familyTree.getAllHuman()) {
            System.out.println(human);
        }
    }

    public void printEventInFamilyTree(){
        for (Event event: this.familyTree.getAllEvent()) {
            System.out.println(event);
        }
    }

    public void removeEvent (int eventId){
        this.familyTree.removeEvent(eventId);
    }

    public void updateEvent(int eventId){
        for (Event event: this.familyTree.getAllEvent()) {
            if (event.getEvent_id() == eventId) {
                this.familyTree.removeEvent(eventId);
            }
        }
    }

    public void removeHuman (int humanId){
        familyTree.deleteHuman(humanId);
    }

    public  FamilyTree getFamilyTree(int familyTreeId){
        return this.listFamilyTrees.get(familyTreeId);
    }

    public List<FamilyTree> getAllFamilyTree(){
        return listFamilyTrees;
    }

    public void setFamilyTree(int familyTreeId){
        for (FamilyTree familyTree : listFamilyTrees) {
            if (familyTree.getFamilyTreeId() == familyTreeId) {
                this.familyTree = familyTree;
            }
        }
    }
}
