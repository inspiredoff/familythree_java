package Service.Comparator;

import java.util.Comparator;

import Model.Human.Human;

public class ComparatorHumanById implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getHumanId() - o2.getHumanId();
    }
}
