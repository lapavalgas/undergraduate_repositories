
package entity;

public class Produto {
    
    private int id;
    private String nome;

    //load
    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    //cadastro
    public Produto (String nome){
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
