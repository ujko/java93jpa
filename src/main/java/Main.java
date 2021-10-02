import dao.PersonDao;
import dao.PersonDaoImpl;
import models.Person;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
        Person p = new Person();
        p.setFirstName("Jan");
        p.setLastName("Kwiatkowski");
        System.out.println(personDao.add(p));

//        System.out.println(personDao.getById(5));
    }
}
