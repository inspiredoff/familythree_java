package Service;

import FamilyTree.FamilyTree;
import Person.Human;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService {
    private FamilyTree familyTree;
    private HumanConstructor humanConstructor;
    private EventConstructor eventConstructor;

    public FamilyTreeService(FamilyTree familyTree, HumanConstructor humanConstructor, EventConstructor eventConstructor) {
        this.familyTree = familyTree;
        this.humanConstructor = humanConstructor;
        this.eventConstructor = eventConstructor;
    }

    public void bornHuman(Human father, Human mother, LocalDate BornDate, String placeName, String childFirstName, Human.gender gender) {
        Human child = humanConstructor.setName(childFirstName, father.getFamilyName(), father.getFirstName()+"ич", gender)
                                    .setBirthDate(BornDate)
                                    .setParent(father, mother)
                                    .build();
        for (Human human: List.of(father, mother)){
            humanConstructor.setHuman(human);
            humanConstructor.addChild(child).build();
        }
        familyTree.addHuman(child);
        // familyTree.addEvent(eventConstructor.bornEvent(BornDate, placeName, father, mother, child));
    }
    
    public void bornHuman(LocalDate BornDate, String placeName, String childFirstName, String childLastName, String familyName, Human.gender gender) {
        Human child = humanConstructor.setName(childFirstName, childLastName, familyName, gender)
                                    .setBirthDate(BornDate)
                                    .build();

        familyTree.addHuman(child);
        familyTree.addEvent(eventConstructor.bornEvent(BornDate, placeName, child));
    }

    public void setParent(Human father, Human mother, Human human){
        humanConstructor.setHuman(human);
        humanConstructor.setParent(father, mother);
    }

    public void wendingHuman(Human wife, Human husband, LocalDate wendingDate, String placeName){
        humanConstructor.setHuman(wife);
        humanConstructor.setSpouse(husband);                            
        humanConstructor.setHuman(husband);
        humanConstructor.setSpouse(wife);
     
        familyTree.addEvent(eventConstructor.wendingEvent(wendingDate, placeName, wife, husband));
        }

    public void deadHuman(Human human, LocalDate deathDay, String placeName) {
        humanConstructor.setHuman(human);
        humanConstructor.setDeathDate(deathDay);

        familyTree.addEvent(eventConstructor.deadEvent(deathDay, placeName, human));
        }
    }
