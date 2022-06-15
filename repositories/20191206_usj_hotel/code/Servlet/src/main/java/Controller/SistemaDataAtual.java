package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Reserva;
import Model.Hospede;
import Repository.HospedeDao;
import Repository.ReservaDao;

@WebServlet("/SistemaDataAtual")
public class SistemaDataAtual extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Open session

		HttpSession sess = request.getSession(true);

		// load date

		DateTimeFormatter format;
		String date;
		List<Reserva> listReservas = new ArrayList<>();

		LocalDate dataSistema;

		if (request.getParameter("data").equals("dataAtual")) {
			System.out.println("message | " + "Carregando a data atual! " + LocalDate.now());
			dataSistema = LocalDate.now();

		} else {
			date = request.getParameter("data");

			System.out.println("message | " + "Formatando a data:  " + date + " | INPUT | ");

			format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dataSistema = LocalDate.parse(date, format);

			System.out.println("message | " + "Formatando a data:  " + dataSistema + " | OUTPUT | ");
		}

		// load reservas

		ReservaDao DAO = new ReservaDao();

		List<Reserva> toParseListReservas = DAO.readReserva(dataSistema);

		HospedeDao DAOH;
		for (Reserva reserva : toParseListReservas) {
			DAOH = new HospedeDao();
			reserva.setHospede(DAOH.readHospede(reserva.getHospede_cpf()));
		}

		sess.setAttribute("data", dataSistema);
		sess.setAttribute("list", toParseListReservas);
		request.setAttribute("data", dataSistema);
		request.setAttribute("list", toParseListReservas);

		System.out.println("::");
		for (Reserva reserva : toParseListReservas) {
			System.out.println("RETURN | " + "data:  " + dataSistema + " | Lista:  " + reserva);
		}

		request.getRequestDispatcher("/dataatual.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
