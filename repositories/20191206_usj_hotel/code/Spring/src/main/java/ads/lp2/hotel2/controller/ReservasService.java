package ads.lp2.hotel2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import ads.lp2.hotel2.model.hospede.Hospede;
import ads.lp2.hotel2.model.hospede.HospedeController;
import ads.lp2.hotel2.model.quarto.Quarto;
import ads.lp2.hotel2.model.quarto.QuartoController;
import ads.lp2.hotel2.model.reserva.Reserva;
import ads.lp2.hotel2.model.reserva.ReservaController;

@RequestMapping
@Controller
public class ReservasService {

    @Autowired
    ReservaController reservaController;

    @Autowired
    QuartoController quartoController;

    @Autowired
    HospedeController hospedeController;

    String date;

    @RequestMapping("/ReservaCancela")
    @ResponseBody
    public RedirectView LocalizarHospede(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(true);

        String date = (String) session.getAttribute("DATE");

        System.out.println(request.getParameter("date"));
        if (request.getParameter("CREATE") != null) {
            System.out.println(request.getParameter("customer['cpf']"));
            Hospede hospede = hospedeController.readHospede(request.getParameter("customer['cpf']"));
            System.out.println(hospede);
            System.out.println(request.getParameter("quarto"));
            Quarto quarto = quartoController.readQuarto(Integer.parseInt(request.getParameter("quarto")));
            System.out.println(quarto);
            Reserva reserva = new Reserva(
                date, 
                Double.parseDouble(request.getParameter("preco")),
                hospede.getId_hospede(), 
                quarto.getId_quarto());
                reservaController.createReserva(reserva);
                System.out.println(reserva);
        }

        if (request.getParameter("UPDATE") != null) {
            Reserva reserva = reservaController.readReserva(Long.parseLong(request.getParameter("idReserva")));
            reserva.setFinalizacao(true);
            reservaController.updateReserva(reserva);
        }

        return new RedirectView("/LoadReservas");

    }

}