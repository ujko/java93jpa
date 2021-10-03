import models.twoObjToOneTable.embedded.Person2;
import models.twoTablesToOneObj.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main2 {
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
        startSession();
        Employee employee = new Employee();
        employee.setFirstName("Tadeusz");
        employee.setLastName("Nowak");
        employee.setCity("Lodz");
        employee.setStreet("Piotrkowska");
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        stopSession();
    }
    public static void main(String[] args) {
        new Main2().doSth();
    }
}
