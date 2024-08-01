package Service;

import Person.HumanBuilderInterface;
import Person.Human.gender;
import Place.Place;

import java.time.LocalDate;
import java.util.List;

import Event.Event;
import Event.EventBuilderInterface;
import Person.Human;
import Person.HumanBuilder;

public class Director {

    private HumanBuilderInterface humanBuilder;
    private EventBuilderInterface eventBuilder;
    private int placeId;
    
    public Director(HumanBuilderInterface humanBuilder, EventBuilderInterface eventBuilder) {
        this.humanBuilder = humanBuilder;
        this.eventBuilder = eventBuilder;
    }

    public void createHuman(HumanBuilder builder,
                            String firstName,
                            String lastName,
                            String familyName,
                            Human.gender gender
                            ){
        builder
                .setId()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setFamilyName(familyName)
                .setGender(gender);
    }

    public void createBirthDate(HumanBuilder builder,
                                LocalDate birthDate,
                                String place){
        builder
                .setBirthDate(birthDate)
                .setEvent(creatEvent("birthday", birthDate, place));
    }

    public void createDeathDate(HumanBuilder builder,
                                LocalDate deadDate,
                                String place){
        builder
                .setDeathDate(deadDate)
                .setEvent(creatEvent("dead", deadDate, place, null));
    }
    
    public void setParents(HumanBuilder builder,
                            Human father,
                            Human mother){
        builder
                .setFather(father)
                .setMother(mother);
                            }
    public void setWending(HumanBuilder builder,
                            Human spouce,
                            LocalDate date,
                            String place){
        builder
                .setSpouse(spouce)
                .setEvent(creatEvent("wending", date, place, spouce));
                            }
    // public void setChildren(HumanBuilder builder,
    //                         Human children
    //                         ){
    //     builder
    //             .setChildren(children)
    //             .setEvent(creatEvent("birthday children", children.getBirthDate(), children.getEvents().get(0).getPlace(), children));

    //     }

    public HumanBuilder getHuman(HumanBuilder builder){
        return builder;
    }

    private Event creatEvent(String nameEvent, LocalDate evenDate, String namePlace, Human...persons){
        return eventBuilder
                            .setEventId()
                            .setEventName(nameEvent)
                            .setEventDate(evenDate)
                            .setPersons(List.of(persons))
                            .setPlace(new Place(placeId++, namePlace))
                            .build();
    }

}
