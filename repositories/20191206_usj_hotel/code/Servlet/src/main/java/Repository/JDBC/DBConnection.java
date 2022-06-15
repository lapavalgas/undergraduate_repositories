package Repository.JDBC;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection getConnection() {

        Connection connection = null;

        try {                                                               // "com.mysql.cj.jdbc.Driver");
            Class.forName(                                                  // "com.mysql.jdbc.Driver");
                    DBInfo.getDriver());                                    // driver

            try {

                connection = DriverManager.getConnection(DBInfo.getUrl(),   // url
                        DBInfo.getUser(),                                   // user
                        DBInfo.getPass());                                  // pass

            } catch (SQLException ex) {

                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error ao conectar no Banco de Dados!   |   " + ex);
                ex.printStackTrace(); 

            }
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error ao carregar o Driver!");

        }

        return connection;
    }
}
