import models.oneToOne.Student;
import models.oneToOne.StudentBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

        Query<StudentBook> query = session.createQuery("select b from StudentBook b", StudentBook.class);
        List<StudentBook> bookList =  query.getResultList();
        bookList.forEach(System.out::println);

//        StudentBook book = new StudentBook();
//        book.setBookName("Pan samochodzik");
//
//        Student student = new Student();
//        student.setStudentName("Jarek");
//        student.setStudentBook(book);
//        book.setStudent(student);
//
//        Transaction tx = session.beginTransaction();
//        session.save(book);
//        session.save(student);
//        tx.commit();

        stopSession();
    }

    public static void main(String[] args) {
        new Main2().doSth();
    }
}
