package Service;

import FamilyTree.FamilyTree;
import Person.Event.Event;
import Person.Human;
import Service.Comparator.ComparatorHumanByAge;
import Service.Comparator.ComparatorHumanById;
import Service.Comparator.ComparatorHumanByName;

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
        for (Human human : this.familyTree.getListHuman()) {
            System.out.println(human);
        }
    }

    public void printEventInFamilyTree(){
        for (Event event : this.familyTree.getListEvent()) {
            System.out.println(event);
        }
    }

    public void removeEvent (int eventId){
        this.familyTree.removeEvent(eventId);
    }

    public void updateEvent(int eventId){
        for (Event event : this.familyTree.getListEvent()) {
            if (event.getEvent_id() == eventId) {
                this.familyTree.removeEvent(eventId);
            }
        }
    }

    public void removeHuman (int humanId){
        familyTree.deleteHuman(humanId);
    }

    public FamilyTree getFamilyTree(int familyTreeId) {
        for (FamilyTree familyTree : listFamilyTrees) {
            if (familyTree.getFamilyTreeId() == familyTreeId) {
                return familyTree;
            }
        }
        return null;
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

    public Event getBornEventByHuman(int humanId){
        Event e = null;
        for (Event event : this.familyTree.getListEvent()) {
            if (event.getEventName().equals("born Human") && event.getPersons().get(0).getHumanId() == humanId) {
                e = event;
            }
        }
        return e;
    }

    public void sortHumanByName() {
        List<Human> humanList = this.familyTree.getListHuman();
        humanList.sort(new ComparatorHumanByName());
    }

    public void sortHumanByAge() {
        List<Human> humanList = this.familyTree.getListHuman();
        humanList.sort(new ComparatorHumanByAge());
    }

    public void sortHumanById() {
        List<Human> humanList = this.familyTree.getListHuman();
        humanList.sort(new ComparatorHumanById());
    }


}
