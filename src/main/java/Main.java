import dao.PersonDao;
import dao.PersonDaoImpl;
import models.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        new Main().doSth();
    }
}
