package Controller;

import java.io.*;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/app")
public class App extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
               
    String uname=request.getParameter("username");  
    out.print("Hello "+ uname);  
    out.close();  
  }
} 