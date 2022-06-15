
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Add" })
public class Add extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private int pplcount;

	public void init(){
		pplcount=1;
	}

	/**
	 * Service, doPost, doGet --> This need to be according to the client request;
	 * if HTML cast a GET, sou use doGet, if cast a post, doPost, and so on... And,
	 * so, can be used to restric the client! Observe that the server cant be fully
	 * control of the request (injections...).
	 */

	// public void service(HttpServletRequest req, HttpServletResponse res) throws
	// IOException {

	// int t1 = Integer.parseInt(req.getParameter("t1"));
	// int t2 = Integer.parseInt(req.getParameter("t2"));

	// int sum = t1 + t2;

	// PrintWriter out = res.getWriter();
	// out.println(sum);

	// }

	/***
	 * With the following methods I can process the client request and treat adequate.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		processRequest(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		processRequest(req, res);
	}

	public void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

		int t1 = Integer.parseInt(req.getParameter("t1"));
		int t2 = Integer.parseInt(req.getParameter("t2"));

		int sum = t1 + t2;

		PrintWriter out = res.getWriter();
		out.println("soma dos números: " + sum + " || Contador de visitas: " + pplcount);
		pplcount++;
	}

}
