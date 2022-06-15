import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * The follow codes take an request from client and send any menssage... -->
         * here go to SecondServlet!
         */

        /**
         * This send the client menssage foraward! like to say that is the same request
         */
        // RequestDispatcher rd = request.getRequestDispatcher("SecondServlet");
        // rd.forward(request, response);

        /**
         * This call a servlet, but dont send the client menssage! like to say this is a
         * new request
         */
        // response.sendRedirect("SecondServlet");

        /***
         * The follow works like a session, and can send the message foward!
         */
        String name = request.getParameter("n1");
        // HttpSession session = request.getSession();
        // session.setAttribute("name", name);
        response.sendRedirect("SecondServlet?name="+name); //this last is after learn cookies, to undertanding that we dont need a sesseion for this simples examples
    }

}