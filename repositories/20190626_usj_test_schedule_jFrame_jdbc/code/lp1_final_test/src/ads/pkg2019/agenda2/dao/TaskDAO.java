package ads.pkg2019.agenda2.dao;

import ads.pkg2019.agenda2.dao.impl.TaskDAOImpl;
import ads.pkg2019.agenda2.dao.jdbc.ConnectionDAO;
import ads.pkg2019.agenda2.entity.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskDAO implements TaskDAOImpl {

    public boolean CREAT(Task task) {
        boolean validity;
        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "INSERT INTO task (fk_schedule, title, creat_time) VALUES (?, ?, CURDATE())";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getFk_schedule());
            statement.setString(2, task.getTitle());
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
    public List<Task> READ(int fk_schedule) {

        List<Task> tasks;
        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "SELECT * FROM task WHERE fk_schedule = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, fk_schedule);
            ResultSet resultSet = statement.executeQuery();

            tasks = new ArrayList<>();

            while (resultSet.next()) {
                Task task = new Task(
                        resultSet.getInt("pk_task"),
                        resultSet.getInt("fk_schedule"),
                        resultSet.getString("title"),
                        resultSet.getString("resume"), 
                        resultSet.getDate("alert"),
                        resultSet.getDate("creat_time"));
                tasks.add(task);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationDAO.class.getName()).log(Level.SEVERE, null, ex);
            tasks = null;
        }
        return tasks;
    }

    @Override
    public boolean UPDATE(Task task) {
        boolean validity;

        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "UPDATE task SET title = ?, resume = ?, alert = ? WHERE pk_task = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getResume());
            statement.setDate(3, task.getAlert());
            statement.setInt(4, task.getPk_task());
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
    public boolean DELET(int pk_task) {

        boolean validity;
        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "DELETE FROM task WHERE pk_task = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pk_task);
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
    public boolean DELETAll(int fk_schedule) {

        boolean validity;
        try {
            Connection connection = ConnectionDAO.getConnection();

            String sql = "DELETE FROM task WHERE fk_schedule = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, fk_schedule);
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
