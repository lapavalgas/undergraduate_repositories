package ads.pkg2019.agenda2.dao.impl;

import ads.pkg2019.agenda2.entity.Authentication;

public interface AuthDAOImpl {
    
    public int AUTH(Authentication auth);
    public boolean AUTH(String login);
    
}
