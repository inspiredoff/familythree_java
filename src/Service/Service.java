package Service;

import FamilyTree.FamilyTree;
import Person.Human;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree familyTree;
    private FamilyTreeService service;
    private HumanConstructor humanConstructor;
    private EventConstructor eventConstructor;

    public Service(String FamilyTreeeName) {
        createNewTree(FamilyTreeeName);
        this.humanConstructor = new HumanConstructor();
        this.eventConstructor  = new EventConstructor();
        this.service = new FamilyTreeService(familyTree, humanConstructor, eventConstructor);
    }

    public void createNewTree(String FamilyTreeeName) {
        this.familyTree = new FamilyTree(this.id++, FamilyTreeeName);
    }

    public void bornChild(Human father, Human mother, LocalDate BornDate, String placeName, String childFirstName, Human.gender gender) {
        service.bornHuman(father, mother, BornDate, placeName, childFirstName, gender);
    }

    public void wendingHuman(Human wife, Human husband, LocalDate wendingDate, String placeName) {
        service.wendingHuman(wife, husband, wendingDate, placeName);
    }

    public void deadHuman(Human human, LocalDate deathDay, String placeName) {
        service.deadHuman(human, deathDay, placeName);
    }


    public void createNewEvent(String event_name, LocalDate event_date, String placeName, List<Human> persons) {
        eventConstructor.newEvent(event_name, event_date, placeName, persons);
    }

    public void searchHuman() {
        //TODO реализовать поиск человека по его данным
    }

    public void searchEvent() {
        //TODO реализовать поиск события по его данным
    }

    public void deleteHuman() {
        //TODO реализовать удаление человека
    }

    public void deleteEvent() {
        //TODO реализовать удаление события
    }


}
