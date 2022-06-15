package ads.lp2.hotel2.model.hospede;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // --=> This is equivalent writing both @Controller and @ResponseBody
@RequestMapping("/hospedes")
public class HospedeController {

  @Autowired
  private HospedeRepository hospedeRepository;

  @PostMapping(path = "/create")
  public String createHospede(@RequestParam String name, @RequestParam String cpf) {
    hospedeRepository.save(new Hospede(name, cpf));
    return (">> Hospede cadastrado com sucesso!");
  }

  @PostMapping(path = "/read") // cpf
  public Hospede readHospede(@RequestParam String cpf) {
    return hospedeRepository.findByCpf(cpf);
  }

  @PostMapping(path = "/readId") // id
  public Hospede readHospedeId(@RequestParam Long id) {
    return hospedeRepository.findById(id).get();
  }

  @PostMapping(path = "/update")
  public String updateHospede(@RequestParam Hospede hospede) {
    hospedeRepository.save(hospede);
    return (">> Hospede atualizado com sucesso!");
  }

  @PostMapping(path = "/delete")
  public String deleteHospede(@RequestParam Hospede hospede) {
    hospedeRepository.delete(hospede);
    return (">> Hospede deletado com sucesso!");
  }

  @PostMapping(path = "/all")
  public List<Hospede> Hospede() {
    return hospedeRepository.findAll();
  }

}
