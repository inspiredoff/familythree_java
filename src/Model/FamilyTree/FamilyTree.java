package Model.FamilyTree;

import Model.Event.Event;
import Model.Person.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private int id;
    private String familyTreeName;
    private List<Human> humans;
    private List<Event> events;

    public FamilyTree(int id, String familyTreeName) {
        this.id = id;
        this.familyTreeName = familyTreeName;
        humans = new ArrayList<>();
        events = new ArrayList<>();
    }

    public Human getHuman(int human_id) {
        for (Human human : humans) {
            if (human.getHumanId() == human_id) {
                return human;
            }
        }
        System.out.println("Human not found");
        return null;
    }

    public Event getEvent(int event_id) {
        for (Event event : events) {
            if (event.getEvent_id() == event_id) {
                return event;
            }
        }
        return null;
    }

    public List<Human> getListHuman() {
        return humans;
    }

   public void deleteHuman(int human_id) {
       Human human = getHuman(human_id);
       if (human != null) {
           Human mother = human.getMother();
           Human father = human.getFather();
           Human spouse = human.getSpouse();
           if (mother != null) {
                List<Human> childrens = mother.getChildren();
                childrens.remove(human);
           }
           if (father != null) {
                father.getChildren().remove(human);
           }
           if (spouse != null) {
                spouse.getChildren().remove(human);
           }
           humans.remove(human);
       }

   }

    public void addHuman(Human human) {
        humans.add(human);
    }
    
    public Integer getFamilyTreeId() {
        return id;
    }





}
