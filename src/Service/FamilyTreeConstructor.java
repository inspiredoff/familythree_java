package Service;

import FamilyTree.FamilyTree;
import Person.Human;
import Person.Event.Event;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreeConstructor {
    private int familyTreeId;
    private FamilyTree familyTree;
    private List<FamilyTree> listFamilyTrees;
    

    public FamilyTreeConstructor() {

    }

    public void createFamilyTree(String FamilyTreeName){
        this.familyTree = new FamilyTree(familyTreeId++, FamilyTreeName);
        this.listFamilyTrees.add(familyTree);
    }



    // public void setFamilyTree(int id){
    //     for ;
    // }

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
        return this.getHuman(humanId);
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

    public void removeHuman (int humanId){
        familyTree.deleteHuman(humanId);
    }

    public List<FamilyTree> getAllFamilyTree(){
        return listFamilyTrees;
    }
    }
