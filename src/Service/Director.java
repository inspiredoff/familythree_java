package Service;

import Person.HumanBuilderInterface;
import Person.Human.gender;
import Place.Place;

import java.time.LocalDate;
import java.util.List;

import Event.Event;
import Event.EventBuilderInterface;
import Person.Human;

public class Director {

    private HumanBuilderInterface humanBuilder;
    private EventBuilderInterface eventBuilder;
    private int placeId;
    
    public Director(HumanBuilderInterface humanBuilder, EventBuilderInterface eventBuilder) {
        this.humanBuilder = humanBuilder;
        this.eventBuilder = eventBuilder;
    }

    public Human createHuman(String firstName,
                            String lastName,
                            String familyName,
                            LocalDate birthDate,
                            String placeNameBirth,
                            LocalDate deadDate,
                            String placeNameDead,
                            gender gender,
                            Human father,
                            Human mother
                            // Human spouce,
                            // LocalDate wendingDate,
                            // String placeNameWending,
                            // Human...children
                            ){
        Human human =  humanBuilder
                                    .set_id()
                                    .set_first_name(firstName)
                                    .set_last_name(lastName)
                                    .set_family_name(familyName)
                                    .set_birth_date(birthDate)
                                    .set_death_date(deadDate)
                                    .set_gender(gender)
                                    .set_father(father)
                                    .set_mother(mother)
                                    // .set_spouse(spouce)
                                    // .set_children(children)
                                    .build();

        human.setEvents(creatEvent("Birth", birthDate, placeNameBirth, human));
                                    
        if (deadDate != null){
            human.setEvents(creatEvent("Dead", deadDate, placeNameDead, human));
        }
        // if (spouce != null){
        //     human.setEvents(creatEvent("wending", wendingDate, placeNameWending, spouce));
        //     spouce.setSpouse(human);
        // }
        return human;
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

    public void createEventDead(Human person,
                                LocalDate deadDate,
                                String placeName
                                ){
        person.setDeathDate(deadDate);
        person.setEvents(creatEvent("Dead", deadDate, placeName, person););
        // person.setPlaces(event.getPlace());
        }

    public void createWending(Human wife,
                            Human husband,
                            LocalDate wendiDate,
                            String placeName    
                            ){
        Event event = creatEvent("wending", wendiDate, placeName, wife, husband);
        for(Human human : List.of(wife, husband)){
            human.setEvents(event);
            // human.setPlaces(event.getPlace());
        }
        wife.setSpouse(husband);
        husband.setSpouse(wife);
    }

    public void createBirthChildren(Human father, Human mother, Human children){
        
    }

}
