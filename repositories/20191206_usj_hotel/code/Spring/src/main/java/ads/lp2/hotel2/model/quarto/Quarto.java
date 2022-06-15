package ads.lp2.hotel2.model.quarto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quarto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_quarto;
    private int numeroQuarto;

    public Quarto(int numeroQuarto){
        this.numeroQuarto = numeroQuarto;
    }


}