package Service.Comparator;

import Model.Person.Human;

import java.util.Comparator;

public class ComparatorHumanByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
