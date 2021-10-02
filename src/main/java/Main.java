import models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
//        List<Person> people = main.getPeople();
//        people.forEach(System.out::println);
        Person person = new Person();
        person.setPersonId(2000);
        person.setFirstName("Pawel");
        person.setLastName("Nowak");
        person.setCity("Lodz");
        person.setEmail("pawel@gmail.com");
        main.addPerson(person);
    }

    private void addPerson(Person person) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
        factory.close();
    }

    private List<Person> getPeople() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Query query = session
                .createQuery("select p from Person p", Person.class);
        List<Person> people = query.getResultList();
        return people;
    }

    private void setUpDb() {
        String query = "create table person (" +
                "person_id INT, " +
                "first_name VARCHAR(50), " +
                "last_name VARCHAR(50), " +
                "email VARCHAR(50), " +
                "city VARCHAR(50)" +
                ");";
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = factory.openSession();
//        session.beginTransaction();
//        Query query1 = session.createNativeQuery(query);
//        query1.executeUpdate();
        session.close();
        factory.close();
    }

    private void addRecords() throws IOException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Files.readString(Paths.get("person.sql"))
                .lines()
                .filter(line -> !line.isEmpty())
                .forEach(line -> {
                    Query query = session.createNativeQuery(line);
                    query.executeUpdate();
                });
        session.close();
        factory.close();
    }
}
