package ads.pkg2019.agenda2.dao;

import ads.pkg2019.agenda2.dao.impl.UserDAOImpl;
import ads.pkg2019.agenda2.dao.jdbc.ConnectionDAO;
import ads.pkg2019.agenda2.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO implements UserDAOImpl {

    @Override
    public boolean CREAT(User user) {

        boolean validity;
        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "INSERT INTO user (name, email, login, pass) VALUES (?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPass());
            statement.executeUpdate();
            validity = true;
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationDAO.class.getName()).log(Level.SEVERE, null, ex);
            validity = false;
        }
        return validity;
    }

    @Override
    public User READ(int pk_user) {

        User user = null;
        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "SELECT * FROM user WHERE pk_user = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pk_user);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        pk_user,
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("email"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public boolean UPDATEEmail(User user) {

        boolean validity;

        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "UPDATE user SET email = ? WHERE pk_user = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setInt(2, user.getPk_user());
            statement.executeUpdate();
            validity = true;
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            validity = false;
        }
        return validity;
    }

    @Override
    public boolean UPDATEPass(int pk_user, String pass) {
    
        boolean validity;

        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "UPDATE user SET pass = ? WHERE pk_user = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pass);
            statement.setInt(2, pk_user);
            statement.executeUpdate();
            validity = true;
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            validity = false;
        }
        return validity;    
    }

    @Override
    public boolean DELET(int pk_user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
