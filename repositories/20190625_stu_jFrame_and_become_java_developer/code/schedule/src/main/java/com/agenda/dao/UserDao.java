package com.agenda.dao;

import com.agenda.dao.impl.UserDaoImpl;
import com.agenda.dao.jdbc.Conexao;
import com.agenda.entity.Evento;
import com.agenda.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao implements UserDaoImpl {

    /*
        Cadastro
     */
    @Override
    public boolean verificarLogin(String login) {

        boolean loginSuccess = false;

        try {
            String resultLogin;

            Connection connection = Conexao.getConnection();

            String sql = "SELECT login FROM user WHERE login = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultset = statement.executeQuery();

            if (!resultset.next()) {
//                System.out.println("vazio");
            } else if (login.equals(resultset.getString("login"))) {
//                System.out.println("cheio");
                loginSuccess = !loginSuccess;
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loginSuccess;
    }

    /*
        Cadastro
     */
    @Override
    public boolean verificarPass(String pass) {

        boolean passSuccess = false;

        try {

            Connection connection = Conexao.getConnection();

            String sql = "SELECT pass FROM user WHERE pass = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pass);
            ResultSet resultset = statement.executeQuery();

            if (!resultset.next()) {
            } else if (pass.equals(resultset.getString("pass"))) {
                passSuccess = !passSuccess;
            }

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passSuccess;
    }

    /*
        Cadastro
     */
    @Override
    public boolean cadastrarUser(User user) {

        boolean registerSuccess = false;

        try {

            Connection conenection = Conexao.getConnection();

            String sql = "INSERT INTO user (nome, email, login, pass) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conenection.prepareStatement(sql);
            statement.setString(1, user.getNome());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPass());
            statement.executeUpdate();

            if (verificarLogin(user.getLogin())) {
                registerSuccess = !registerSuccess;
            }

            conenection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registerSuccess;
    }

    /*
        Altera user
     */
    @Override
    public boolean atualizarUser(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
        Altera user
     */
    @Override
    public boolean deletarUser(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
        Carrega agenda / eventos
     */
    @Override
    public User loadUser(String login) {

        User loadUser = null;
        try {
            Connection connection = Conexao.getConnection();
            String sql = "SELECT * FROM user WHERE login = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                User user = new User();
                user.setId_user(resultset.getInt("id_user"));
                user.setNome(resultset.getString("nome"));
                user.setEmail(resultset.getString("email"));
                user.setLogin(resultset.getString("login"));
                user.setPass(resultset.getString("pass"));
                loadUser = user;
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println("deu pau");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return loadUser;
    }

    @Override
    public List<Evento> loadAgenda(int id_user) {

        List<Evento> agenda = null;
        try {
            agenda = new ArrayList<Evento>();
            Connection connection = Conexao.getConnection();
            String sql = "SELECT * FROM evento WHERE fk_user = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_user);
            ResultSet resultset = statement.executeQuery();
            Evento evento;
            while (resultset.next()) {
                evento = new Evento();
                int id_evento;
                String title, resumo;
                id_evento = resultset.getInt("id_evento");
                title = resultset.getString("title");
                resumo = resultset.getString("resumo");
                evento.CarregaEvento(id_evento, title, resumo);
                agenda.add(evento);
            }

            connection.close();

        } catch (SQLException ex) {
            System.out.println("deu pau");
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agenda;
    }
}
