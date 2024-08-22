package Service;

import Model.EntityPerson;
import Model.Gender;

import java.time.LocalDate;

public interface InterEntityConstructor<T extends EntityPerson<T>> {

    public InterEntityConstructor<T> newEntity(T person);

    public InterEntityConstructor<T> newEntity(String firstName, String lastName, String familyName, Gender gender, int familyTreeId);

    public InterEntityConstructor<T> setName(String firstName, String lastName, String familyName, Gender gender, int familyTreeid);

    public InterEntityConstructor<T> setParent(T father, T mother);

    public InterEntityConstructor<T> setSpouce(T spouce);

    public InterEntityConstructor<T> setBirthDate(LocalDate birthDate);

    public InterEntityConstructor<T> setDeathDate(LocalDate deathDate);

    public InterEntityConstructor<T> setChildren(T children);

    public T build();
}

