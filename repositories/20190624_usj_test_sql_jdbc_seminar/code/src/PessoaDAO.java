import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaDAO {
    
        //  Exemplo de uma rotina básica de cadastro no banco de dados;

    /*  No exemplo apresentado o método cadastrarPessoa() precisa de um objeto tipo Connection e Pessoa.
    *   É gerada uma String com o comando SQL básico a ser executado pelo método.
    *   É gerado um objeto preparedStatement através do objeto connection, utilizando a String.
    *   Os valores de ?, ?, ?, ? são tratados através de métodos especiais e de consulta no objeto pessoa.
    *   é utilizada a função .execute() que executa a query.     */

    public void cadastrarPessoa(Connection connection, Pessoa pessoa){
        String sql = "INSERT INTO pessoas (cpf, primeiro_nome, segundo_nome, email, telefone) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement prepareStatement = connection.preparedStatement(sql);
        prepareStatement.setInt(1, pessoa.getCpf());
        prepareStatement.setString(2, pessoa.getPrimeiroNome());
        prepareStatement.setString(3, pessoa.getSegundoNome());
        prepareStatement.setString(4, pessoa.getEMail());
        prepareStatement.setInt(5, pessoa.getTelefone());
        prepareStatement.execute();
    }
        //  Exemplo de uma rotina básica de consulta pessoa no banco de dados através do CPF.

    /*  No exemplo apresentado o método consultarPessoa() precisa de um objeto connection e pessoa.
    *   observação: o objeto pessoa não necessáriamente está completo, mas no mínimo deve vir com o dado CPF.
    *   É gerado uma String com o comando SQL básico a ser executado pelo método.
    *   É gerado um objeto preparedStatement através do objeto connection.
    *   Os valores de ? (o CPF) é tratado através do método especial do preparedStatement e do .getCpf() da pessoa.
    *   É gerado um objeto ResultSet através do método .executeQuery() do objeto preparedStatement.
    *       O objeto ResultSet é exatamente a tabela retornada na query, referente a consulta.
    *   Através da rotina While(resultSet.next()) conseguimos verificar todos os dados retornados na consulta.
    *   esses dados são incluidos no objeto pessoa inicialmente passado para a consulta.
    *   e por fim retorna o objeto pessoa recheado de dados.        */

    public Pessoa consultarPessoa(Connection connection, Pessoa pessoa){
        String sql = "SELECT * FROM pessoas WHERE cpf = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, pessoa.getCpf());
        ResultSet resultSet = preparedStatement.executeQuery(); 
        while(resultSet.next()){
            pessoa.setPrimeiroNome(resultSet.getString("primeiro_nome"));
            pessoa.setSegundoNome(resultSet.getString("segundo_nome"));
            pessoa.setEMail(resultSet.getString("email"));
            pessoa.setTelefone(resultSet.getString("telefone"));
            //...
        }
        return pessoa;
    }
}









