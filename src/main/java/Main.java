import dao.PersonDao;
import dao.PersonDaoImpl;
import models.Address;
import models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
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

    private void doSth() {
        Address address = new Address();
        address.setCity("Warszawa");
        address.setZipCode("99-300");
        address.setStreet("Piotrkowska 5");
        address.setDate(Date.valueOf(LocalDate.now()));
        startSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
        transaction.commit();
        stopSession();
    }

    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
        System.out.println(personDao.getByFirstName("Pawel"));
        System.out.println(personDao.getAll());
        personDao.add(new Person());



//        new Main().doSth();
//        Person person = new Person();
//        person.setFirstName("Pawel");
//        new PersonDaoImpl().add(person);

//        Connection connection = DriverManager
//                .getConnection("jdbc:mysql://localhost:3306/mysql?serverTimezone=Europe/Warsaw", "root", "example");
//
//        Statement statement = connection.createStatement();
//
//        String query = "select * from person";
//        ResultSet resultSet = statement.executeQuery(query);
//        List<Person> personList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Person p = new Person();
//            p.setPersonId(resultSet.getInt("person_id"));
//
//
//            personList.add(p);
//
//        }


    }
}
