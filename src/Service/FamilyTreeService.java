package Service;

import FamilyTree.FamilyTree;
import Person.Human;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService {
    private Human human;
    private FamilyTree familyTree;
    private HumanConstructor humanConstructor;
    private EventConstructor eventConstructor;

    public FamilyTreeService(FamilyTree familyTree, EventConstructor eventConstructor) {
        this.familyTree = familyTree;
        this.human = new Human();
        this.eventConstructor = eventConstructor;
    }

    private void setName(String firstName, String lastName, String familyName, Human.gender gender) {
        human.setFirstName(firstName);
        human.setLastName(lastName);
        human.setFamilyName(familyName);
        human.setGender(gender);
    }

    public void bornHuman(Human father, Human mother, LocalDate BornDate, String placeName, String childFirstName, Human.gender gender) {
        setName(childFirstName, father.getLastName()+"ич", father.getFamilyName(), gender);
        human.setBirthDate(BornDate);
        human.setMother(mother);
        human.setFather(father);
        for (Human human: List.of(father, mother)){
            human.setChildren(List.of(human));
        }
        familyTree.addHuman(human);
        familyTree.addEvent(eventConstructor.bornEvent(BornDate, placeName, father, mother, human));
    }
    
    public void bornHuman(LocalDate BornDate, String placeName, String childFirstName, String childLastName, String familyName, Human.gender gender) {
        setName(childFirstName, childLastName, familyName, gender);
        familyTree.addHuman(human);
        familyTree.addEvent(eventConstructor.bornEvent(BornDate, placeName, human));
    }

    public void setHuman(Human human){this.human = human;}

    public void setParent(Human father, Human mother){
        human.setFather(father);
        human.setMother(mother);
    }

    public void wendingHuman(Human wife, Human husband, LocalDate wendingDate, String placeName){
        wife.setSpouse(husband);
        husband.setSpouse(wife);

        familyTree.addEvent(eventConstructor.wendingEvent(wendingDate, placeName, wife, husband));
        }

    public void deadHuman(LocalDate deathDay, String placeName) {
        human.setDeathDate(deathDay);

        familyTree.addEvent(eventConstructor.deadEvent(deathDay, placeName, human));
        }
    }
