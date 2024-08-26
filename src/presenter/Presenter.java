package presenter;

import Model.Models.Gender;
import Model.Models.Event.Event;
import Model.Models.Human.Human;
import Model.Service.EventDatabase.EventDatabase;
import Model.Service.HumanDatabase.HumanDatabase;
import Model.Service.OriginalDatabase;
import Model.Service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {

    private View view;
    private final Service service;
    private OriginalDatabase<Human> humanDb;
    private OriginalDatabase<Event> eventDb;

    public Presenter(View view) {
        this.humanDb = new HumanDatabase();
        this.eventDb = new EventDatabase();
        this.view = view;
        this.service = new Service(humanDb, eventDb);
    }

//create

    public void createNewTree() {
        service.createNewTree();
    }

    public void bornHuman(String name, String surname, String patronymic, LocalDate birthday, String address, Gender gender) {
        service.bornHuman(name, surname, patronymic, birthday, address, gender);
    }

    public void wendingHuman(int wideId, int husbandId, LocalDate wendingDate, String placeName) {
        service.wendingHuman(wideId, husbandId, wendingDate, placeName);
    }

    public void diedHuman(int id, LocalDate deathDate, String placeName) {
        service.deadHuman(id, deathDate, placeName);
    }

    public void updateEvent(int eventId, String event_name, LocalDate event_date, String placeName) {
        service.updateEvent(eventId, event_name, event_date, placeName);
    }

    //remove

    //print

    public void printFamilyTreeHuman() {
        service.printFamilyTreeHuman();
    }

    public void printEventInFamilyTree() {
        service.printEventInFamilyTree();
    }

    //sort
    public void sortHumanByName() {
        service.sortHumanByName();
    }

    public void sortHumanByAge() {
        service.sortHumanByAge();
    }

    public void sortHumanById() {
        service.sortHumanById();
    }

    //save load

    public void SaveFamilyTree(String filePatchHuman, String filePatchEvent) {
        service.SaveFamilyTree(filePatchHuman, filePatchEvent);
    }

    public void LoadFamilyTree(String filePatch) {
        service.loadFamilyTree(filePatch);
    }
}
