import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Subtracao")
public class SubtracaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("a");
        Integer valorA = Integer.valueOf(a);
        String b = request.getParameter("b");
        Integer valorB = Integer.valueOf(b);

        Integer result = valorA - valorB;

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.print("<h1>");
        out.print(a);
        out.print(" - ");
        out.print(b);
        out.print(" = ");
        out.print(result);
        out.print("</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
