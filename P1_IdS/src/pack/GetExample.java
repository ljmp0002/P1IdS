package pack;

import java.io.*;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/GetExample")

public class GetExample extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Servlet Test</title></head>");
		out.println("<body ><center><h1> SERVLET TEST </h1>");
		String answer = request.getParameter("username");
		out.println("<h2> Username: " + answer + "</h2>");
		Date date = new Date();
		out.println("<h3>The time at the server is " + date.toString() +"</h3>");
		out.println("</center>");

		out.println("<h3>Headers</h3>");
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.print("<p><b>Header Name: </b>" + headerName);
			String headerValue = request.getHeader(headerName);
			out.print(", <b>Header Value: </b>" + headerValue);
		}
		out.println("</p></body></html>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Headers</h3>");
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.print("<p><b>Header Name: </b>" + headerName);
			String headerValue = request.getHeader(headerName);
			out.print(", <b>Header Value: </b>" + headerValue);
		}
		out.println("</p></body></html>");
		out.close();
	}
}
