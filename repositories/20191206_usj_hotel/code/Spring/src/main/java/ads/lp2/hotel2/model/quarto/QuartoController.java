package ads.lp2.hotel2.model.quarto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    @Autowired
    private QuartoRepository quartoRepository;

    @PostMapping(path = "/create")
    public String createQuarto(@RequestParam int numero) {
        quartoRepository.save(new Quarto(numero));
        return (">> Quarto cadastrado com sucesso!");
    }

    @PostMapping(path = "/read") // numeroQuarto
    public Quarto readQuarto(@RequestParam int numero) {
        return quartoRepository.findByNumeroQuarto(numero);
    }

    @PostMapping(path = "/readId") // numeroId
    public Quarto readQuarto(@RequestParam Long numero) {
        return quartoRepository.findById(numero).get();
    }

    @PostMapping(path = "/update")
    public String updateQuarto(@RequestParam Quarto quarto) {
        quartoRepository.save(quarto);
        return (">> Quarto atualizado com sucesso!");
    }

    @PostMapping(path = "/delete")
    public String deleteQuarto(@RequestParam Quarto quarto) {
        quartoRepository.delete(quarto);
        return (">> Quarto deletado com sucesso!");
    }

    @PostMapping(path = "/all")
    public List<Quarto> readAllQuarto() {
        return quartoRepository.findAll();
    }

}
