package com.agenda.dao;

import com.agenda.dao.impl.EventoDaoImpl;
import com.agenda.dao.jdbc.Conexao;
import com.agenda.entity.Evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDao implements EventoDaoImpl {

    @Override
    public boolean createEvent(Evento evento, int id_user) {

        boolean createSuccess = false;

        try {
            Connection connection = Conexao.getConnection();

            String sql = ""
                    + "INSERT INTO evento (title, resumo, fk_user)"
                    + "VALUES (?, ?, (SELECT id_user FROM user WHERE id_user = ?))";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, evento.getTitle());
            statement.setString(2, evento.getResumo());
            statement.setInt(3, id_user);
            statement.executeUpdate();

            createSuccess = !createSuccess;

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return createSuccess;
    }

    @Override
    public boolean editEvent(Evento evento) {

        boolean successEdit = false;

        try {
            String sql = "UPDATE evento SET title = ? ,resumo = ? WHERE id_evento = ? ";

            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, evento.getTitle());
            statement.setString(2, evento.getResumo());
            statement.setInt(3, evento.getId_evento());
            statement.executeUpdate();
            successEdit = !successEdit;
            
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return successEdit;
    }

    @Override
    public boolean deleteEvent(int id) {
        boolean successDelete = false;
        try {

            String sql = "DELETE FROM evento WHERE id_evento = ?";
            
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            successDelete = !successDelete;
            
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return successDelete;
    }
}

/*
INNER JOIN:

SELECT user.nome, user.login, evento.title, evento.resumo
FROM evento
INNER JOIN user ON id_user = fk_user;
 */
