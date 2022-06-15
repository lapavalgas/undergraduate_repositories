import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tryLogin")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (PersonDAO.verLoginPass(login, password)) {
            System.out.println("SUCESS - 1. Login efetuado com sucesso!");
            response.sendRedirect("home.jsp");
        } else {
            System.out.println("ERROR - 1. Falha ao efetuar login!");
            response.sendRedirect("index.jsp");
        }
    }

}