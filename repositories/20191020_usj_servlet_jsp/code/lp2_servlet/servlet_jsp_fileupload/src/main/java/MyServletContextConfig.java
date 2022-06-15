import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServletContextConfig")
public class MyServletContextConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hi<br/>");

		ServletConfig cg = getServletConfig();
		String str = cg.getInitParameter("name");
		out.println(str);
	}

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// PrintWriter out = response.getWriter();
	// out.println("Hi<br/>");

	// ServletContext ctx = getServletContext(); //this is a context in WEB.XML
	// String str = ctx.getInitParameter("name"); //with this can store values in
	// XML for a context
	// out.println(str);
	// }


	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// PrintWriter out = response.getWriter();
	// out.println("Hello from Servlet");
	// }

	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// doGet(request, response);
	// }

}
