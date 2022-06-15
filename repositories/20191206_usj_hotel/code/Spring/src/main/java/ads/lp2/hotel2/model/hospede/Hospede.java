package ads.lp2.hotel2.model.hospede;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hospede {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_hospede;

    private String nome;
    private String cpf;

    public Hospede(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
}