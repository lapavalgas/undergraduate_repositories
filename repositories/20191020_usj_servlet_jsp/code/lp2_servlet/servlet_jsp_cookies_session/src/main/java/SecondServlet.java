import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * In requests from firstservlet come here
         */
        String nameRequest = request.getParameter("n1");
        System.out.println(nameRequest + " name from request");



        // This are ommit to not crash the server
        /**
         * In requests from secondservlet come here this codes open ans session object,
         * and let the ThirdOne Servlet send an object through the session
         */
        // HttpSession session = request.getSession();

        // String nameSession = session.getAttribute("name").toString();
        // System.out.println(nameSession + " name from session");



        /**
         * In requests from FourCookie come here! To work: Need send an Cookie! An send
         * a name in a request name!
         * 
         */

        Cookie cookies[] = request.getCookies();
        String anCookie = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("cookie")) {
                anCookie = c.getValue();
            }
        }
        System.out.println(anCookie);



        /***
         * This just a sample for look to requestdispatcher class --> but nav bar will
         * say "FirstServlet" /
         */
        PrintWriter out = response.getWriter();
        out.print("in second servlet!!" + request.getParameter("name"));
    }

}