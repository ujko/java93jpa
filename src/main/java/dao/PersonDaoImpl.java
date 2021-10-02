package dao;

import models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDaoImpl implements PersonDao {
    private SessionFactory factory;
    private Session session;

    private void startSession() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        session = factory.openSession();
    }

    private void stopSession() {
        factory.close();
        session.close();
    }

    @Override
    public Person add(Person person) {
        person.setPersonId(getNewId());
        startSession();
        Transaction tr = session.beginTransaction();
        Integer p = (Integer) session.save(person);
        tr.commit();
        stopSession();
        return getById(p);
    }

    @Override
    public Person modify(int personId, Person person) {
        return null;
    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public Person getById(int personId) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public List<Person> getByFirstName(String firstName) {
        return null;
    }

    private int getNewId() {
        int result = 0;
        startSession();
        Query<Integer> query = session.createNamedQuery("getId", Integer.class);
        result = query.getSingleResult();
        stopSession();
        return result + 1;
    }

    private int getNewIdFromAll() {
        return getAll()
                .stream()
                .mapToInt(Person::getPersonId)
                .max()
                .orElse(0) + 1;
    }
}
