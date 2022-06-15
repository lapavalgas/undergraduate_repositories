import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
	
	
	//FIELDS
	//Determina uma variavel-objeto Con de conexão.
	//
	private Connection con = DBCon.getConnection();
	
	
	//METHODS
	//Método de cadastro no banco de dados.
	//
	public void cadastrarActor(Actor actor) {
		String sql = "INSERT INTO actor (first_name, last_name, email, senha) VALUES (?, ?, ?, MD5(?))";
		try{
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, actor.getFirst_nome());
			preparador.setString(2, actor.getLast_name());
			preparador.setString(3, actor.getEmail());
			preparador.setString(4, actor.getSenha());
			preparador.execute();
			preparador.close();
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro cadastro - "+e.getMessage());
		}
	}
	
	
	//
	//Método de atualização de dados no banco de dados.
	//
	public void atualizarActor(Actor actor) {
		String sql = "UPDATE actor SET first_name = ?, last_name = ?, email = ?, senha = MD5(?) WHERE id =?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, actor.getFirst_nome());
			preparador.setString(2, actor.getLast_name());
			preparador.setString(3, actor.getEmail());
			preparador.setString(4, actor.getSenha());
			preparador.setInt(5, actor.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Atualizado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro atualizar - "+e.getMessage());
		}
	}
	
	//
	//Método de deletação de dados no banco de dados.
	//
	public void deletarActor(Actor actor) {
		String sql = "DELETE FROM actor WHERE id = ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, actor.getId());
			preparador.executeUpdate();
			preparador.close();
			System.out.println("Deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro atualizar - "+e.getMessage());
		}
	}
	
	//retorna tabela do banco de dados (toda tabela)
	//
	public List<Actor> carregarTodosActor(Actor actor){
		String sql = "SELECT * FROM actor";
		List<Actor> lista = new ArrayList<Actor>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while(resultados.next()) {
				Actor actr = new Actor();
				actr.setId(resultados.getInt("id"));
				actr.setFirst_nome(resultados.getString("first_name"));
				actr.setLast_name(resultados.getString("last_name"));
				actr.setEmail(resultados.getString("email"));
				actr.setSenha(resultados.getString("senha"));
				lista.add(actr);				
			}
			System.out.println("Carregado tabela com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro buscar - "+e.getMessage());
		}
		return lista;		
	}	
	
	//Retorna linha de tabela do banco de dados (linha tabela)
	//
	public Actor carregarLinhaActor(Actor actorRow){
		String sql = "SELECT * FROM actor WHERE id = ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, actorRow.getId());
			ResultSet resultados = preparador.executeQuery();
			while(resultados.next()) {
				//actorRow.setId(resultados.getInt("id"));
				actorRow.setFirst_nome(resultados.getString("first_name"));
				actorRow.setLast_name(resultados.getString("last_name"));
				actorRow.setEmail(resultados.getString("email"));
				actorRow.setSenha(resultados.getString("senha"));				
			}
			System.out.println("Carregado linha com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro buscar - "+e.getMessage());
		}
		return actorRow;		
	}	
	// Todos os métodos possuem variavel em escopo chamada 'sql' que indica o comando a ser encaminhado.

}
