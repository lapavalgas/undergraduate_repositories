package sistema;

import javax.swing.JOptionPane;

import entity.User;
import gui.Login;

public class Sistema {
    
    public static User user;

    public static void main(String[] args) {
        
        Login login = new Login();
        login.setVisible(true);
        
    }
    
}
 