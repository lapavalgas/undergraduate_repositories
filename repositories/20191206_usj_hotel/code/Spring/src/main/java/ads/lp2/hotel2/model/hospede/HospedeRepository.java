package ads.lp2.hotel2.model.hospede;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {

    Hospede findByCpf(String cpf);

}
