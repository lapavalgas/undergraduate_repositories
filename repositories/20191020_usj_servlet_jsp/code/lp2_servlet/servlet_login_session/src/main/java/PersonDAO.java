
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public static boolean verLoginPass(String login, String password) {

        boolean statusLogin = false;
        boolean statusPassword = false;
        boolean status = false;

        List<Person> persons = new ArrayList<>();

        persons.add(new Person(1, "lapavalgas", "rafa", "Rafael", "Lapavalgas", "Music"));
        persons.add(new Person(2, "mtmachado", "paul", "Paula", "Machado Teixeira", "Psychology"));

        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getLogin().equals(login)) {
                statusLogin = true;
            }
            if (persons.get(i).getPassword().equals(password)) {
                statusPassword = true;
            }
            if (statusLogin == true && statusPassword == true) {
                status = true;
            }
        }
        return status;
    }
}