import dao.ClienteDAO;
import dao.jdbc.AluguelDAOimpl;
import dao.jdbc.ClienteDAOImpl;
import dao.jdbc.FilmeDAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private final static String url = "jdbc:postgresql://localhost/banco_de_dados";
    private final static String user = "postgres";
    private final static String password = "entrar";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            ClienteDAO clienteDAO = new ClienteDAOImpl();
            AluguelDAOimpl aluguelDAO = new AluguelDAOimpl();
            FilmeDAOimpl filmeDAO = new FilmeDAOimpl();
            System.out.println(clienteDAO.list(conn));
            System.out.println(aluguelDAO.list(conn));
            System.out.println(filmeDAO.list(conn));
            System.out.println(clienteDAO.list(conn));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - Abrir Conex�o: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error - Fechar Conex�o: " + e.getMessage());
            }
        }
        System.out.println("Fim do teste.");
    }
}