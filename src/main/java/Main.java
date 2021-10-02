import dao.PersonDao;
import dao.PersonDaoImpl;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
        personDao
                .getByFirstName("t")
                .forEach(System.out::println);
    }
}
