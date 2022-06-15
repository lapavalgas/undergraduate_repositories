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

@RequestMapping
@Controller
public class CadastrosService {

    @Autowired
    HospedeController hospedeController;

    Hospede hospede;

    @RequestMapping("/LocalizarHospede")
    @ResponseBody
    public RedirectView LocalizarHospede(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("READ") != null) {

            HttpSession session = request.getSession(true);

            String cpf = (String) request.getParameter("CPF");
            Hospede hospede = hospedeController.readHospede(cpf);

            session.setAttribute("CPF", cpf);
            session.setAttribute("HOSPEDE", hospede);

            System.out.println(request.getAttribute("HOSPEDE"));

            System.out.println("--=> " + hospede);
        }

        if (request.getParameter("DELETE") != null) {

            HttpSession session = request.getSession(true);

            String cpf = (String) request.getParameter("CPF");
            Hospede hospede = hospedeController.readHospede(cpf);
            String status = hospedeController.deleteHospede(hospede);

            System.out.println("--=> " + status);
        }
        return new RedirectView("/SistemaCadastro");

    }

    @RequestMapping("/SaveHospede")
    @ResponseBody
    public RedirectView SaveHospede(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("CREATE") != null) {

            HttpSession session = request.getSession(true);

            String name = (String) request.getParameter("hospedeName");
            String cpf = (String) request.getParameter("hospedeCpf");

            String status = hospedeController.createHospede(name, cpf);
            Hospede hospede = hospedeController.readHospede(cpf);
            session.setAttribute("HOSPEDE", hospede);

            System.out.println(request.getAttribute("HOSPEDE"));

            System.out.println("--=> " + hospede);
        }

        if (request.getParameter("UPDATE") != null) {

            HttpSession session = request.getSession(true);

            Hospede hospede = (Hospede) session.getAttribute("HOSPEDE");
            String nome = request.getParameter("hospedeName");
            String cpf = request.getParameter("hospedeCpf");
            hospede.setNome(nome);
            hospede.setCpf(cpf);

            String status = hospedeController.updateHospede(hospede);

            System.out.println("--=> " + status);
        }
        return new RedirectView("/SistemaCadastro");

    }

}