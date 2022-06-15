package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Hospede;
import Repository.HospedeDao;

@WebServlet("/HospedeController")
public class HospedeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 1. verifica o botão apertado; 2. verifica a existencia do hospede na DB 3.
		 * Cadastra se não existir 4. Atualiza se existir OBS.: É importante que sejá
		 * utilizado os botões corretos.
		 */

		HospedeDao DAO;

		Hospede _hospede = new Hospede(
			request.getParameter("hospedeName"), 
			request.getParameter("hospedeCpf"));

		/**
		 * CADASTRAR | EDITAR
		 */
		if (request.getParameter("create") != null) {

			System.out.println(_hospede + " |  CREATE");

			DAO = new HospedeDao();
			if (DAO.readHospede(_hospede.getCpf()) instanceof Hospede) {
				System.out.println("message " + "Hospede já cadastado!");
				request.setAttribute("message", "Hospede já cadastado!");
				_hospede = null;
			} else {
				DAO.createHospede(_hospede);
				_hospede = DAO.readHospede(_hospede.getCpf());
			}

		} else if (request.getParameter("update") != null) {

			System.out.println(_hospede + " |  UPDATE");

			DAO = new HospedeDao();
			if (DAO.readHospede(_hospede.getCpf()) instanceof Hospede) {
				DAO.updateHospede(_hospede);
				_hospede = DAO.readHospede(_hospede.getCpf());
			} else {
				System.out.println("message | " + "Hospede não cadastrado!");
				request.setAttribute("message", "Hospede não cadastrado!");
				_hospede = null;
			}

			/**
			 * LOCALIZAR | DELETAR
			 */
		} else if (request.getParameter("read") != null) {
			System.out.println(_hospede + " |  READ");

			DAO = new HospedeDao();
			if (DAO.readHospede(_hospede.getCpf()) instanceof Hospede) {
				_hospede = DAO.readHospede(_hospede.getCpf());
			} else {
				System.out.println("message | " + "Hospede não cadastrado!");
				request.setAttribute("message", "Hospede não cadastrado!");
				_hospede = null;
			}

		} else if (request.getParameter("delete") != null) {
			System.out.println(_hospede + " |  DELETE");

			DAO = new HospedeDao();
			if (DAO.readHospede(_hospede.getCpf()) instanceof Hospede) {
				DAO.deleteHospede(request.getParameter("hospedeCpf"));
				_hospede = null;
			} else {
				System.out.println("message | " + "Hospede não cadastrado!");
				request.setAttribute("message", "Hospede não cadastrado!");
				_hospede = null;
			}
		} else {
			System.out.println(_hospede + " |  ERROR");

			System.out.println("Algo deu errado na verificação dos botões!");
			_hospede = null;
		}
		System.out.println(_hospede + " |  RETURN");

		request.setAttribute("hospede", _hospede);
		request.getRequestDispatcher("/cadastrar.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

/**
 * BACKUP: response.sendRedirect(request.getContextPath() + "/cadastrar.jsp");
 */