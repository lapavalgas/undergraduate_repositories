package Repository;

import Model.Hospede;
import Repository.JDBC.DBConnection;
import Repository.impl.HospedeDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HospedeDao implements HospedeDaoImpl {

    private Connection connection;
    private String sql;

    @Override
    public void createHospede(Hospede _hospede) {
        try {
            connection = DBConnection.getConnection();
            sql = "INSERT INTO hospede (cpf, nome) VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, _hospede.getCpf());
            statement.setString(2, _hospede.getNome());
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(HospedeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Hospede readHospede(String _cpf) {

        Hospede _hospede = null;
        try {
            connection = DBConnection.getConnection();
            sql = "SELECT * FROM hospede WHERE cpf = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, _cpf);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                _hospede = new Hospede(
                    resultSet.getInt("id_hospede"),
                    resultSet.getString("nome"), 
                    resultSet.getString("cpf"));
            }
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(HospedeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return _hospede;
    }

    @Override
    public void updateHospede(Hospede _hospede) {
        try {
            connection = DBConnection.getConnection();
            sql = "UPDATE hospede SET nome = ? WHERE cpf = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, _hospede.getNome());
            statement.setString(2, _hospede.getCpf());
            
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(HospedeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteHospede(String _cpf) {
        try {
            connection = DBConnection.getConnection();
            sql = "DELETE FROM hospede WHERE cpf = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, _cpf);
            
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(HospedeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
