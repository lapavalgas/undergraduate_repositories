package ads.lp2.hotel2.model.reserva;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserva {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_reserva;

    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dataDia;

    private Double preco;
    private boolean finalizacao;

    private Long id_hospede;
    private Long id_quarto;

    public boolean getFinalizacao() {
        return this.finalizacao;
    }

    public Reserva(String dataDia, double preco, Long id_hospede, Long id_quarto){
        this.dataDia = dataDia;
        this.preco = preco;
        this.id_hospede = id_hospede;
        this.id_quarto = id_quarto;
        this.finalizacao = false;
    }

}