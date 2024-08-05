package Service;

import FamilyTree.FamilyTree;

public class Service {
    private int id;
    private FamilyTree familyTree;
    private FamilyTreeService service;
    private HumanConstructor humanConstructor;
    private EventConstructor eventConstructor;

    public Service(String FamilyTreeeName) {
        this.familyTree = new FamilyTree(this.id++, FamilyTreeeName);
        this.humanConstructor = new HumanConstructor();
        this.eventConstructor  = new EventConstructor();
        this.service = new FamilyTreeService(familyTree, humanConstructor, eventConstructor);
    }

    public void createNewTree() {
    }

    public void createNewHuman(Human father, ) {
        service.bornHuman(null, null, null, null, null, null);
    }

    public void changing_person_data() {

    }

    public void createNewEvent() {
        //TODO попробовать реализовать изменение человека через добавление событий
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
