package FamilyTree;

import Person.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int id;
    private String familyTreeName;
    private int human_id = 0;
    private List<Human>humans;

    public FamilyTree(int id, String familyTreeName) {
        this.id = id;
        this.familyTreeName = familyTreeName;
        humans = new ArrayList<>();
    }

    private void addHuman(Human human) {
        human.setHumanId(human_id);
        human_id++;
        humans.add(human);
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

    public void deleteHuman(int human_id) {
        Human human = getHuman(human_id);
        if (human != null) {
            Human mother = human.getMother();
            Human father = human.getFather();
            Human spouse = human.getSpouse();
            if (mother != null) {
                mother.removeChildren(human);
            }
            if (father != null) {
                father.removeChildren(human);
            }
            if (spouse != null) {
                spouse.setSpouse(null);
            }
            humans.remove(human);
        }

    }

    public
    void createHuman(
            String first_name,
            String last_name,
            String family_name,
            LocalDate birth_date,
            LocalDate death_date,
            Human.gender gender
    ) {
        Human human = new Human(first_name, last_name, family_name, birth_date, death_date, gender);
        addHuman(human);
    }
    public void createChildren(
            String first_name,
            String last_name,
            String family_name,
            LocalDate birth_date,
            LocalDate death_date,
            Human.gender gender,
            int father_id,
            int mother_id) {
        Human father = null;
        Human mother = null;
        for (Human human : humans) {
            if (human.getHumanId() == father_id) {
                father = human;
            } else if (human.getHumanId() == mother_id) {
                mother = human;
            }
        }
        if (father != null || mother != null) {
            Human children = new Human(
                    first_name,
                    last_name,
                    family_name,
                    birth_date,
                    death_date,
                    gender,
                    father,
                    mother);
            if (father != null) {
                father.setChildren(children);
            }
            if (mother != null) {
                mother.setChildren(children);
            }
//            father.setChildren(children);
//            mother.setChildren(children);
            addHuman(children);
        } else {
            System.out.println("Parent not found");
        }
    }

    public void printFamilyTree() {
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    public void printHuman(int human_id) {
        for (Human human : humans) {
            if (human.getHumanId() == human_id) {
                System.out.println(human);
            }
        }
    }

}
