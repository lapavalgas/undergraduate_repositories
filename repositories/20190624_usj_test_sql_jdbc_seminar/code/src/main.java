import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {

            //  Cria conexão.
        Connection connection = DBCon.getConnection();
        
            //  Gera um objeto pessoaDAO para as operações.  ---> Melhor Static?!
        PessoaDAO pessoaDAO = new PessoaDAO();

            //  Gera um objeto pessoa através de um construtor e cadastra no banco de dados.
        Pessoa objPessoa1 = new Pessoa(00000000000, "Jaime", "Miranda", "jaime@miranda.junior.br", 489000000000);
        pessoaDAO.cadastrarPessoa(connection, objPessoa1);

            //  Cria um objeto pessoa apenas com CPF e identifica os dados através de uma consulta na base de dados.
        Pessoa objPessoa2 = new Pessoa();
        objPessoa2.setCpf(00000000000);
        objPessoa2 = PessoaDAO.consultarPessoa(connection, objPessoa2);

            //  Finaliza conexão com o driver do banco de dados.
        connection.close();
        }
}




