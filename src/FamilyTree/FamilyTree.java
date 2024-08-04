package FamilyTree;

import Person.Event.Event;
import Person.Human;

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

    public List<Human> getFamilyTree() {
        return humans;
    }

//    public void deleteHuman(int human_id) {
//        Human human = getHuman(human_id);
//        if (human != null) {
//            Human mother = human.getMother();
//            Human father = human.getFather();
//            Human spouse = human.getSpouse();
//            if (mother != null) {
//                mother.removeChildren(human);
//            }
//            if (father != null) {
//                father.removeChildren(human);
//            }
//            if (spouse != null) {
//                spouse.setSpouse(null);
//            }
//            humans.remove(human);
//        }
//
//    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void getEvent(int event_id) {
        for (Event event : events) {
            if (event.getEvent_id() == event_id) {
                System.out.println(event.toString());
            }
        }
    }

    public void removeEvent(int event_id) {
        for (Event event : events) {
            if (event.getEvent_id() == event_id) {
                events.remove(event);
            }
        }
    }





}
