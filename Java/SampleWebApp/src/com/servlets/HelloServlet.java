package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet{

	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		
		String message = request.getParameter("msg");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h2> Hello Servlet </h2");
		writer.println("<p>Message: " + message + "</p>");
		writer.println("<p>Generated date: " + new Date().toString() + "</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		
	}

}
