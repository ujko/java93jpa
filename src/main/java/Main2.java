import models.Person;
import models.twoTablesToOneObj.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main2 {
    private SessionFactory factory;
    private Session session;

    private SessionFactory factoryTest;
    private Session sessionTest;

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

    private void startSessionTest() {
        factoryTest = new Configuration()
                .configure("hibernate2.cfg.xml")
                .buildSessionFactory();
        sessionTest = factoryTest.openSession();
    }

    private void stopSessionTest() {
        factoryTest.close();
        sessionTest.close();
    }

    private void doSth() {
        startSession();
        Query<Person> query = session.createQuery("select p from Person p");
        List<Person> personList = query.getResultList();
        stopSession();
        startSessionTest();
        Transaction tx = sessionTest.beginTransaction();
        personList.forEach(x -> sessionTest.save(x));
        tx.commit();
        stopSessionTest();
    }
    
    public static void main(String[] args) {
        new Main2().doSth();
    }
}
