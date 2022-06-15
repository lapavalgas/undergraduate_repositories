public class Person {

    private int id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private String favs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFavs() {
        return favs;
    }

    public void setFavs(String favs) {
        this.favs = favs;
    }

    @Override
    public String toString() {
        return "Person [favs=" + favs + ", id=" + id + ", lastName=" + lastName + ", login=" + login + ", name=" + name
                + ", password=" + password + "]";
    }

    public Person(int id, String login, String password, String name, String lastName, String favs) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.favs = favs;
    }

}