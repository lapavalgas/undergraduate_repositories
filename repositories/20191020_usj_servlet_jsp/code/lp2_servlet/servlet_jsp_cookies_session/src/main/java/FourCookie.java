import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FourCookie")
public class FourCookie extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /**
         * Works like an session, but is the cookie available in client-side; 
         * Common in online shoppings.
         * Can hold for a time, like 10 minutes...
         */
        String anCookie = request.getParameter("n1");
       
        Cookie cookie = new Cookie("cookie", anCookie);
        response.addCookie(cookie);
        response.sendRedirect("SecondServlet");
    }

}