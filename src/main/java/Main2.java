import models.inheritance.Daughter;
import models.inheritance.Son;
import models.oneToMany.Client;
import models.oneToMany.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
        List<Client> clientList = session.createQuery("select c from Client c").getResultList();
        System.out.println(clientList.get(0));
        System.out.println("-----------------------------------------------------");
        clientList.get(0).getOrders().forEach(System.out::println);
        stopSession();
//        clientList.get(0).getOrders().forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Main2().doSth();
    }
}
