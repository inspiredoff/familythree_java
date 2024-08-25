package presenter;

import Model.Models.Gender;
import Model.Service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
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

    public void diedHuman(int id, LocalDate deathDate) {
        service.deadHuman(id, deathDate, "", 0);
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

    public void saveFamilyTree(String filePatchHuman, String filePatchEvent, Integer familyTreeId) {
        service.saveFamilyTree(filePatchHuman, filePatchEvent, familyTreeId);
    }

    public void loadFamilyTree(String filePatch) {
        service.loadFamilyTree(filePatch);
    }

}
