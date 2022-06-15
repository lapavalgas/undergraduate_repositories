
package ads.lp2.hotel2.model.reserva;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findAllByDataDia(String dataDia);

}