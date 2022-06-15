package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Reserva;
import Repository.ReservaDao;

@WebServlet("/ReservaController")
public class ReservaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sess = request.getSession(true);

        ReservaDao DAO = new ReservaDao();

        if (request.getParameter("update").equals("reservar")) {

            System.out.println("Reservando...");

            Reserva _reserva = new Reserva(request.getParameter("customer['cpf']"), request.getParameter("quarto"),
                    request.getParameter("data"), request.getParameter("preco"));

            System.out.println("Reservando... " + _reserva);

            System.out.println("Enviando ao banco de dados.");

            DAO.createReserva(_reserva);

            System.out.println("Retornando ao sistema!");

        } else if (request.getParameter("update").equals("cancelar")) {

        } else {

        }

        RequestDispatcher rs = request.getRequestDispatcher("/SistemaDataAtual");

        request.setAttribute("data", sess.getAttribute("data"));

        rs.forward(request, response);

        // response.sendRedirect(request.getContextPath() + "/SistemaDataAtual");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
