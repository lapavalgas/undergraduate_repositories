public class Actor {
	
	//FIELDS
	//Representa o objeto para retorno dos dados do banco de dados. 
	//Não precisa ser identico ao banco de dados, esse pode ser já a abstração do sistemas, pois um objeto podera se comunicar
	//de diferentes maneiras com o banco de dados.
	//
	private Integer id;	
	private String first_nome;
	private String last_name;
	private String email;
	private String senha;
	
	//METHODS
	//Gets and Sets
	//
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_nome() {
		return first_nome;
	}
	public void setFirst_nome(String first_nome) {
		this.first_nome = first_nome;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
