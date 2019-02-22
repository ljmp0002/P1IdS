package pack;

import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


/**
 * Servlet implementation class HoraServlet
 */
@WebServlet("/HoraServlet")

public class HoraServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter html = response.getWriter();
		html.print("<strong>");
		Date date = (Date)sesion.getAttribute("date");
		if(date != null) {
			html.print("Último acceso de la sesión: " + date + "<br>");
			}
		else {
			html.print("Este es el primer acceso de la sesión <br>");
			}
		date = new Date();
		sesion.setAttribute("date", date);
		html.print("Fecha actual: " + date);
		html.print("</strong>");
	}
}