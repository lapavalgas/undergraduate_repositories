package ads.lp2.hotel2.model.reservas;

import ads.lp2.hotel2.model.hospede.Hospede;
import ads.lp2.hotel2.model.quarto.Quarto;
import ads.lp2.hotel2.model.reserva.Reserva;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllReservas {

    private Reserva reserva;
    private Hospede hospede;
    private Quarto quarto;

}