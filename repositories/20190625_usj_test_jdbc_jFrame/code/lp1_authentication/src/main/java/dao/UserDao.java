package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.jdbc.Conexao;
import entity.User;

public class UserDao {

//    private final static String table = "usuario_3";
    
    public boolean VerificarEmail(String email) {

        boolean resultado = false;

        try {
            Connection connection = Conexao.getConnection();

            String sql = "SELECT email FROM usuario_3 WHERE email = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, UserDao.table);
            statement.setString(1, email);
            ResultSet resultset = statement.executeQuery();
            
            while (resultset.next()){
                resultado = email.equals(resultset.getString("email"));
            }
            
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }

    public boolean VerificarPassword(String senha) {

        boolean resultado = false;

        try {
            Connection connection = Conexao.getConnection();

            String sql = "SELECT senha FROM usuario_3 WHERE senha = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, UserDao.table);
            statement.setString(1, senha);
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()){
                resultado = senha.equals(resultset.getString("senha"));
            }
            
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }

     public boolean CadastrarUser(User user) {

        boolean resultado = false;

        try {
            Connection connection = Conexao.getConnection();

            String sql = "INSERT INTO usuario_3 (nome, email, senha) values (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, UserDao.table);
            statement.setString(1, user.getNome());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getSenha());

            resultado = statement.execute();

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }
     
    public User LoadUser(String email) {

        User user = null;

        try {
            Connection connection = Conexao.getConnection();

            String sql = "SELECT * FROM usuario_3 WHERE email = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, UserDao.table);
            statement.setString(1, email);
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {

                User userCarregando = new User();

                userCarregando.setId(resultset.getInt("id"));
                userCarregando.setNome(resultset.getString("nome"));
                userCarregando.setEmail(resultset.getString("email"));
                userCarregando.setSenha(resultset.getString("senha"));

                user = userCarregando;
            }

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
