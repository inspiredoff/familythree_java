package FamilyTree;

import java.io.Serializable;

public class FamilyTree implements Serializable {
//    private int id;
//    private String familyTreeName;
//    private List<Human>humans;
//
//    public FamilyTree(int id, String familyTreeName) {
//        this.id = id;
//        this.familyTreeName = familyTreeName;
//        humans = new ArrayList<>();
//    }
//
//    public Human getHuman(int human_id) {
//        for (Human human : humans) {
//            if (human.getHumanId() == human_id) {
//                return human;
//            }
//        }
//        System.out.println("Human not found");
//        return null;
//    }
//
//    public List<Human> getHumanList() {
//        return humans;
//    }
//
//    public void addHuman(Human human) {
//        humans.add(human);
//    }

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
//
////    public int getgrandMother(int human_id) {
////        Human human = getHuman(human_id);
//        if (human != null) {
//            Human mother = human.getMother();
//            if (mother != null) {
//                Human grandMother = mother.getMother();
//                if (grandMother != null) {
//                    return grandMother.getHumanId();
//                }
//            }
//        }
//        return -1;
//        }
//
//    public int getgrandFather(int human_id) {
//        Human human = getHuman(human_id);
//        if (human != null) {
//            Human father = human.getFather();
//            if (father != null) {
//                Human grandFather = father.getFather();
//                if (grandFather != null) {
//                    return grandFather.getHumanId();
//                }
//            }
//        }
//        return -1;
//    }



}
