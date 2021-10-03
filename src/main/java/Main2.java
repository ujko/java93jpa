import models.inheritance.Daughter;
import models.inheritance.Son;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        Son son = new Son();
        son.setSonName("Juzek");
        son.setDadId(1);
        son.setDadName("Krystyna");

        Daughter daughter = new Daughter();
        daughter.setDaughterName("Ola");
        daughter.setDadId(2);
        daughter.setDadName("Tadziu");

        Transaction tx = session.beginTransaction();
        session.save(son);
        session.save(daughter);
        tx.commit();

        stopSession();
    }

    public static void main(String[] args) {
        new Main2().doSth();
    }
}
