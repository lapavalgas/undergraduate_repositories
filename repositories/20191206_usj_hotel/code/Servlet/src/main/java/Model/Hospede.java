package Model;

import lombok.*;

@Data
public class Hospede {

    private int id_Hospede;
    private String nome;
    private String cpf;

    public Hospede(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;

    }

    public Hospede(int id_hospede, String nome, String cpf) {
        this.id_Hospede = id_hospede;
        this.nome = nome;
        this.cpf = cpf;
    }

}