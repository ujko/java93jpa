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
        stopSession();
        Transaction transaction = session.beginTransaction();
        Person p = getByIdWithoutSession(personId);
        p.setPerson(person);
        transaction.commit();
        stopSession();
        return null;
    }

    @Override
    public void delete(int personId) {
        startSession();
        Transaction transaction = session.beginTransaction();
        Person person = getByIdWithoutSession(personId);
        session.delete(person);
        transaction.commit();
        stopSession();
    }

    private Person getByIdWithoutSession(int personId) {
        Query<Person> query = session.createNamedQuery(Person.GET_BY_ID, Person.class);
        query.setParameter("personId", personId);
        return query.getSingleResult();
    }

    @Override
    public Person getById(int personId) {
        startSession();
        Person person = getByIdWithoutSession(personId);
        stopSession();
        return person;
    }

    @Override
    public List<Person> getAll() {
        startSession();
        Query<Person>  query = session.createNamedQuery("getAll", Person.class);
        List<Person> personList = query.getResultList();
        stopSession();
        return personList;
    }

    @Override
    public List<Person> getByFirstName(String firstName) {
        startSession();
        Query<Person> query = session.createNamedQuery("getByFirstName", Person.class);
        query.setParameter("firstName", "%" + firstName + "%");
        List<Person> personList = query.getResultList();
        stopSession();
        return personList;
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
