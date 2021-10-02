import dao.PersonDao;
import dao.PersonDaoImpl;
import models.Person;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
        Person p = new Person();
        p.setLastName("Nowak");
        System.out.println(personDao.add(p));
    }
}
