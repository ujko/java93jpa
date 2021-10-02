package dao;

import models.Person;

import java.util.List;

public interface PersonDao {
    Person add(Person person);
    Person modify(int personId, Person person);
    void delete(int personId);
    Person getById(int personId);
    List<Person> getAll();
    List<Person> getByFirstName(String firstName);
}
