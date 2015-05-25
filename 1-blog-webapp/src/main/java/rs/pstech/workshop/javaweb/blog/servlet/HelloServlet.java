package rs.pstech.workshop.javaweb.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 561731399261100579L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Blog Application</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<div style=\"width: 60%; margin: 0 auto;\">");
		out.println("		<form id=\"hello\" action=\"\" method=\"POST\">");
		out.println("			<div style=\"width: 80%; margin: 0 auto;\">");
		out.println("				<table>");
		out.println("					<tbody>");
		out.println("						<tr>");
		out.println("							<td width=\"20%\" align=\"right\" valign=\"top\"><label>Your name:</label></td>");
		out.println("							<td width=\"10%\"></td>");
		out.println("							<td width=\"70%\" align=\"left\"><input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Your name:\"></td>");
		out.println("						</tr>");
		out.println("						<tr>");
		out.println("							<td width=\"20%\" align=\"right\" valign=\"top\"></td>");
		out.println("							<td width=\"10%\"></td>");
		out.println("							<td width=\"70%\" align=\"left\"><input type=\"submit\" value=\"Enter\"></td>");
		out.println("						</tr>");
		out.println("					</tbody>");
		out.println("				</table>");
		out.println("		</div>");
		out.println("</form>");
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String name = request.getParameter("name");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Blog Application</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<div style=\"width: 60%; margin: 0 auto;\">");
		out.println("			<h3 align=\"center\">Hello " + name + "</h3>");
		out.println("	</div>");
		out.println("	<div style=\"width: 60%; margin: 0 auto;\">");
		out.println("			<h3 align=\"left\"><a href=\"\" align=\"center\">Index</a></h3>");
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
