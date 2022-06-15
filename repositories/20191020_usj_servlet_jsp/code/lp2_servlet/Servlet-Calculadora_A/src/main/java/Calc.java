import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class Calc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));

        String operador = request.getParameter("operador");

        double result = 0;

        switch (operador) {
        case "Somar":
            result = num1 + num2;
            break;
        case "Subtrair":
            result = num1 - num2;
            break;
        case "Dividir":
            result = num1 / num2;
            break;
        case "Multiplicar":
            result = num1 * num2;
            break;
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.print("<h1>");
        out.println(result);
        out.print("</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}