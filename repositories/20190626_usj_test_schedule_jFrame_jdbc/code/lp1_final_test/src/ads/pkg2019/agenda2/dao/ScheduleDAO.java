package ads.pkg2019.agenda2.dao;

import ads.pkg2019.agenda2.dao.impl.ScheduleDAOImpl;
import ads.pkg2019.agenda2.dao.jdbc.ConnectionDAO;
import ads.pkg2019.agenda2.entity.Schedule;
import ads.pkg2019.agenda2.sis.Sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleDAO implements ScheduleDAOImpl {

    @Override
    public boolean CREAT(int fk_user, String name) {

        boolean validity;
        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "INSERT INTO schedule (fk_user, name) VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, fk_user);
            statement.setString(2, name);
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
    public List<Schedule> READ(int pk_user) { //faz a leitura de  todas as agendas

        List<Schedule> schedules;
        
        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "SELECT * FROM schedule WHERE fk_user = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pk_user);
            ResultSet resultSet = statement.executeQuery();

            schedules = new ArrayList<>();

            while (resultSet.next()) {
                Schedule schedule = new Schedule(
                        resultSet.getInt("pk_schedule"),
                        resultSet.getInt("fk_user"),
                        resultSet.getString("name"));
                schedules.add(schedule);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationDAO.class.getName()).log(Level.SEVERE, null, ex);
            schedules = new ArrayList<>();
        }
        return schedules;
    }

    @Override
    public boolean UPDATE(Schedule schedule) {

        boolean validity;

        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "UPDATE schedule SET name = ? WHERE pk_schedule = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, schedule.getName());
            statement.setInt(2, schedule.getPk_schedule());
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
    public boolean DELET(int pk_schedule) {

        boolean validity;
        try {
            Connection connection = ConnectionDAO.getConnection();
            
            TaskDAO tasks = new TaskDAO();
            tasks.DELETAll(pk_schedule);
            
            String sql = "DELETE FROM schedule WHERE pk_schedule = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pk_schedule);
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

}
