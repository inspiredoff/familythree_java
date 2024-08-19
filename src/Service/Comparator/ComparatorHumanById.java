package Service.Comparator;

import Model.Person.Human;

import java.util.Comparator;

public class ComparatorHumanById implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getHumanId() - o2.getHumanId();
    }
}
