import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	
	//FIELDS
	//Define URL: jdbc://postgresql://[endere�o]:[porta]/database. Define Username e Password de acesso ao banco de dados. 
	//
	private final static String url = "jdbc:postgresql://localhost/ex01test";
	private final static String user = "postgres";
	private final static String password = "entrar";
	
	//METHODS
	//Define o m�todo padr�o de conex�o com o banco de dados do postgresql. O Try Catch � compuls�rio e auxilia na interpreta��o dos erros do SQL.
	//
	public static Connection getConnection() {
		Connection con = null;
		try {
			try {
				Class.forName("org.postgresql.Driver");
				System.out.println("Driver carregado com sucesso!");				
			} catch (ClassNotFoundException e) {
				System.out.println("Error - Driver: "+e.getMessage());
			}
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Error - Conex�o: "+e.getMessage());
		}
		return con;
		
	}

}
