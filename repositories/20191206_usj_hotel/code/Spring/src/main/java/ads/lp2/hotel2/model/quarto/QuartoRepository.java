package ads.lp2.hotel2.model.quarto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    Quarto findByNumeroQuarto(int numeroQuarto);

}
