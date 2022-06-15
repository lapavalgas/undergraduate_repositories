import java.util.List;

public class TestDAO {

	public static void main(String[] args) {
		//cadastroActor();
		//alterarActor();
		//deletarActor();
		//buscarTodosActor();
		buscarActor();
	}
	
	//Cadastrar
	public static void cadastroActor() {
		Actor actor = new Actor();
		actor.setFirst_nome("Paula");
		actor.setLast_name("Machado Teixeira");
		actor.setEmail("lapavalgas@gmail.com");
		actor.setSenha("teste");
		ActorDAO actorDao = new ActorDAO();
		actorDao.cadastrarActor(actor); 
	}
	
	//Alterar
	public static void alterarActor() {
		Actor actor = new Actor();
		actor.setFirst_nome("Rafael");
		actor.setLast_name("Lapa Valgas");
		actor.setEmail("lapavalgas@gmail.com");
		actor.setSenha("senha");
		actor.setId(3);
		ActorDAO actorDao = new ActorDAO();
		actorDao.atualizarActor(actor);			 
	}
	
	//Deletar
	public static void deletarActor() {
		Actor actor = new Actor();
		actor.setFirst_nome("Rafael");
		actor.setLast_name("Valgas");
		actor.setEmail("lapavalgas@gmail.com");
		actor.setSenha("teste");
		actor.setId(2);
		ActorDAO actorDao = new ActorDAO();
		actorDao.deletarActor(actor);			
	}
	
	//Carregar Tabela
	public static void buscarTodosActor() {
		Actor actor = new Actor();
		ActorDAO actorDao = new ActorDAO();
		List<Actor> listaResultado = actorDao.carregarTodosActor(actor);
		for(Actor actr:listaResultado) {
			System.out.println("id: "+actr.getId()+" Nome: "+actr.getFirst_nome()+" "+actr.getLast_name()+" E-Mail: "+actr.getEmail()+" ");
		}
		System.out.println(listaResultado);
	}
	
	//Carregar Linha Tabela
	public static void buscarActor() {
		Actor actor = new Actor();
		actor.setId(3);
		ActorDAO actorDao = new ActorDAO();
		actor = actorDao.carregarLinhaActor(actor);
		System.out.println("id: "+actor.getId()+" Nome: "+actor.getFirst_nome()+" "+actor.getLast_name()+" E-Mail: "+actor.getEmail()+" ");
		System.out.println(actor);
	}
	
	

}
