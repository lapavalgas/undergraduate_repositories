package ads.lp2.hotel2.controller;

import java.text.ParseException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import ads.lp2.hotel2.model.hospede.Hospede;
import ads.lp2.hotel2.model.quarto.QuartoController;

@Controller
public class navService {

	@Autowired
	QuartoController quartoController;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/Login")
	@ResponseBody
	public RedirectView Login(HttpServletRequest request, HttpServletResponse response) throws ParseException {

		if (quartoController.readAllQuarto().size() <= 4) {
			quartoController.createQuarto(1);
			quartoController.createQuarto(2);
			quartoController.createQuarto(3);
			quartoController.createQuarto(4);
			quartoController.createQuarto(5);
			System.out.println("Foram cirado CINCO quartos de hotel!");
		}

		HttpSession session = request.getSession(true);

		LocalDate getDate = LocalDate.now();
		String date = DateService.parseLocalDateToString(getDate, "yyyy-MM-dd");

		session.setAttribute("DATE", date);

		Hospede hospede = null;

		session.setAttribute("HOSPEDE", hospede);

		return new RedirectView("/LoadReservas");
	}

	@RequestMapping("/UserDate")
	@ResponseBody
	public RedirectView UserDate(HttpServletRequest request, HttpServletResponse response) throws ParseException {

		HttpSession session = request.getSession(true);

		String date = request.getParameter("DATE");

		session.setAttribute("DATE", date);

		String hospede = null;

		session.setAttribute("HOSPEDE", hospede);

		return new RedirectView("/LoadReservas");
	}

	@RequestMapping("/SistemaDataAtual")
	public String SistemadataAtualController() {
		return "dataatual";
	}

	@RequestMapping("/SistemaCadastro")
	public String SistemaCadastroController() {
		return "cadastros";
	}

}