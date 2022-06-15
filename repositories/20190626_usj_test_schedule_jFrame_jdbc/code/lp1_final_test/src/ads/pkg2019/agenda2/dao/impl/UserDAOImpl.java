package ads.pkg2019.agenda2.dao.impl;

import ads.pkg2019.agenda2.entity.User;

public interface UserDAOImpl {

    public boolean CREAT(User user);

    public User READ(int pk_user);

    public boolean UPDATEEmail(User user);

    public boolean UPDATEPass(int pk_user, String pass);

    public boolean DELET(int pk_user);
}
