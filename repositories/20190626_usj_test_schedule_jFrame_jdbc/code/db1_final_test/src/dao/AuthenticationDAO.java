package ads.pkg2019.agenda2.dao;

import ads.pkg2019.agenda2.dao.impl.AuthDAOImpl;
import ads.pkg2019.agenda2.dao.jdbc.ConnectionDAO;
import ads.pkg2019.agenda2.entity.Authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthenticationDAO implements AuthDAOImpl {

    @Override
    public int AUTH(Authentication auth) {

        int pk_user = -1;

        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "SELECT pk_user FROM user WHERE login = ? AND pass = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, auth.getLogin());
            statement.setString(2, String.valueOf(auth.getPass()));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                pk_user = resultSet.getInt("pk_user");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pk_user;
    }

    @Override
    public boolean AUTH(String login) {

        boolean validity;

        try {
            Connection connection = ConnectionDAO.getConnection();
            String sql = "SELECT pk_user FROM user WHERE login = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("login").length() >= 1) {
                    validity = true;
                }
                validity = false;
            }
            validity = false;
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationDAO.class.getName()).log(Level.SEVERE, null, ex);
            validity = false;
        }
        return validity;
    }
}
