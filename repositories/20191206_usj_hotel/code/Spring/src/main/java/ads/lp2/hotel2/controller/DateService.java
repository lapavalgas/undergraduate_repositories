package ads.lp2.hotel2.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import ads.lp2.hotel2.model.hospede.HospedeController;
import ads.lp2.hotel2.model.quarto.QuartoController;
import ads.lp2.hotel2.model.reserva.Reserva;
import ads.lp2.hotel2.model.reserva.ReservaController;
import ads.lp2.hotel2.model.reservas.AllReservas;

@RequestMapping
@Controller
public class DateService {

    @Autowired
    ReservaController reservaController;

    @Autowired
    QuartoController quartoController;

    @Autowired
    HospedeController hospedeController;

    String date;

    @RequestMapping("/LoadReservas")
    @ResponseBody
    public RedirectView LoadReservas(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(true);

        String date = (String) session.getAttribute("DATE");

        List<Reserva> reservas = reservaController.allReservasByDatadia(date);
        reservas = removeTrueList(reservas);
        reservas = fullNullList(reservas);

        List<AllReservas> allReservas = createReservasList(reservas);
        allReservas = ordenaList(allReservas);

        session.setAttribute("RESERVAS", allReservas);

        System.out.println("--=> " + allReservas);

        return new RedirectView("/SistemaDataAtual");

    }

    public List<AllReservas> ordenaList(List<AllReservas> allReservas) {

        /**
         * This keep the List ordered by the room numbers
         */
        // ordenação da lista
        List<AllReservas> cleanList = new ArrayList<AllReservas>();

        for (AllReservas cleaningList : allReservas) {
            AllReservas clean = null;
            cleanList.add(clean);
        }

        for (int i = 0; i < allReservas.size(); i++) {
            if (allReservas.get(i) != null) {
                cleanList.set(allReservas.get(i).getQuarto().getNumeroQuarto() - 1, allReservas.get(i));
                // allReservas.set(i, null);
            }
        }
        return cleanList;
    }

    public List<AllReservas> createReservasList(List<Reserva> reservas) {

        /**
         * This List<> like an private ModelView 
         */
        List<AllReservas> allReservas = new ArrayList<AllReservas>();
        for (Reserva reserva : reservas) {
            try {
                AllReservas allReserva = new AllReservas();
                allReserva.setReserva(reserva);
                allReserva.setHospede(hospedeController.readHospedeId(reserva.getId_hospede()));
                allReserva.setQuarto(quartoController.readQuarto(reserva.getId_quarto()));
                allReservas.add(allReserva);
            } catch (Exception e) {
                AllReservas allReserva = null;
                allReservas.add(allReserva);
            }
        }
        return allReservas;
    }

    public List<Reserva> removeTrueList(List<Reserva> reservas) {

        /**
         * Clean the reservas OK
         */
        List<Reserva> reservaFalse = new ArrayList<Reserva>();

        for (Reserva reserva : reservas) {
            if (reserva.getFinalizacao() == false) {
                reservaFalse.add(reserva);
            }
        }
        return reservaFalse;
    }

    public List<Reserva> fullNullList(List<Reserva> reservas) {

        /**
         * Always need the ArrayList size 5
         */
        int blankReserva = (5 - reservas.size());
        for (int i = 0; i < blankReserva; i++) {
            Reserva r = null;
            reservas.add(r);
        }
        return reservas;
    }

    public static Date parseStringToDate(String date, String type) throws ParseException {
        Date newDate = new SimpleDateFormat(type).parse(date);
        return newDate;
    }

    public static LocalDate parseStringToLocalDate(String date, String type) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(type);
        LocalDate parsing = LocalDate.parse(date, format);
        return parsing;
    }

    public static String parseLocalDateToString(LocalDate localDateNow, String type) {
        String formattedDate = localDateNow.format(DateTimeFormatter.ofPattern(type));
        return formattedDate;
        // return localDateNow.toString();
    }

}