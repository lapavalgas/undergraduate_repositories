package ads.lp2.hotel2.model.reserva;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// @Controller
// @ResponseBody // --=> Or can put the @ResponseBody in class mapping to all take this!
@RestController // --=> This is equivalent writing both @Controller and @ResponseBody
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    // --=> Observe that I can put the @ResponseBody just in the method! 
    @PostMapping(path = "/create")
    public String createReserva(@RequestParam Reserva reserva) {
        reservaRepository.save(reserva);
        return (">> Reserva cadastrada com sucesso!");
    }

    @PostMapping(path = "/read")
    public Reserva readReserva(@RequestParam Long id) {
        return reservaRepository.findById(id).get();
    }

    @PostMapping(path = "/update") // used just to set true
    public String updateReserva(@RequestParam Reserva reserva) {
        reservaRepository.save(reserva);
        return (">> Reserva atualizada com sucesso!");

    }

    @PostMapping(path = "/delete")
    public String deleteReserva(@RequestParam Reserva reserva) {
        reservaRepository.delete(reserva);
        return (">> Reserva deletada com sucesso!");
    }

    @PostMapping(path = "/all")
    public List<Reserva> allReservas() {
        return reservaRepository.findAll();
    }
    @PostMapping(path = "/allByDay")
    public List<Reserva> allReservasByDatadia(String dataDia) {
        return reservaRepository.findAllByDataDia(dataDia);
    }

}
