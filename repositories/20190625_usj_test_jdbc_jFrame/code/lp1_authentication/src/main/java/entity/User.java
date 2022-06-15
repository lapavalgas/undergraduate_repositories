package entity;

public class User {
    int id;
    String nome, email, senha;
    
    public User(){
        
    }
    public void CadastrarUser(String nome, String email, String senha){
        this.nome=nome;
        this.email=email;
        this.senha=senha;
    }
    public void LoadUser(int id, String nome, String email, String senha){
        this.id=id;
        this.nome=nome;
        this.email=email;
        this.senha=senha;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
