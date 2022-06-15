import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {

        //  Atributos para o método .getConnection().
        //  Uma boa prática seria isolar em uma classe e utilizar métodos getters.
    private final static String url = "jdbc:postgresql://localhost/dvdrental";
	private final static String user = "postgres";
    private final static String password = "entrar";
    
    //Exemplo de uma rotina básica de conexão ao driver do banco de dados;

    /*  No exemplo apresentado é gerado um objeto null Connection nomeado connection;
    *   Tenta gerar uma conexão através da classe e método DriverManager.getConnection();
    *   Se não houver erros irá gerar um objeto. 
    *   Em caso de erros avisará através do primeiro try{}cacth{}; 
    *   ao gerar o objeto a função irá retornar esse objeto de conexão ao solicitante.  */

    public static Connection getConnection() {
            //  Gera um objeto null do tipo Connection.
        Connection connection = null; 
            //  Em caso de erro é preciso verificar endereço, login ou senha.
		try { 
                //  Gera o objeto Connection através do método .getConnection().
			connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
            /
		} catch (SQLException e) {
			System.out.println("Error - Conexão: "+e.getMessage());
        }
            //  Retorna o objeto connection.
		return connection;
    }


