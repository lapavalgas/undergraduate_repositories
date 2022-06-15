package ads.pkg2019.agenda2.entity;

public class User {

    int pk_user;
    String name, login, email;
    String pass;

    public User() {
    }

    public User(String name, String login, String email, String pass) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.pass=pass;
    }

    public User(int pk_user, String name, String login, String email) {
        this.pk_user=pk_user;
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public int getPk_user() {
        return pk_user;
    }

    public void setPk_user(int pk_user) {
        this.pk_user = pk_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
