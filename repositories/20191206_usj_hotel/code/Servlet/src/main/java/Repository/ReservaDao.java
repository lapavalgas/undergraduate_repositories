package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Reserva;
import Repository.JDBC.DBConnection;
import Repository.impl.ReservaDaoImpl;

public class ReservaDao implements ReservaDaoImpl {

    private Connection connection;
    private String sql;

    @Override
    public void createReserva(Reserva _reserva) {
        try {
            connection = DBConnection.getConnection();
            sql = "INSERT INTO reserva (hospede_cpf, quarto, dataDia, preco, finalizacao) VALUES (?, ?, ?, ?, false)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, _reserva.getHospede_cpf());
            statement.setInt(2, _reserva.getQuarto());
            statement.setObject(3, _reserva.getDataDia());
            statement.setDouble(4, _reserva.getPreco());
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reserva> readReserva(LocalDate _date) {

        List<Reserva> _listReserva = null;
        Reserva _reserva;

        try {

            connection = DBConnection.getConnection();

            sql = "SELECT * FROM reserva WHERE dataDia = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, _date);
            ResultSet resultSet = statement.executeQuery();

            _listReserva = new ArrayList<Reserva>();

            while (resultSet.next()) {
                _reserva = new Reserva(
                    resultSet.getInt("id_Reserva"), 
                    resultSet.getString("hospede_cpf"),
                        resultSet.getInt("quarto"), 
                        resultSet.getDate("dataDia").toLocalDate(),
                        resultSet.getDouble("preco"), 
                        resultSet.getBoolean("finalizacao"));

                _listReserva.add(_reserva);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return _listReserva;
    }

    @Override
    public void updateReserva(Reserva _reserva) {
        try {
            connection = DBConnection.getConnection();
            sql = "UPDATE reserva SET finalizacao = true WHERE id_reserva = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, _reserva.getId_Reserva());

            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reserva> listReserva(LocalDate _date1, LocalDate _date2) {
        // TODO Auto-generated method stub
        return null;
    }

}