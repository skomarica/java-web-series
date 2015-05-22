package rs.pstech.workshop.javaweb.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.pstech.workshop.javaweb.blog.model.Blog;
import rs.pstech.workshop.javaweb.blog.service.BlogService;
import rs.pstech.workshop.javaweb.blog.service.BlogServiceImpl;

public class AllBlogServlet extends HttpServlet {

	private static final long serialVersionUID = -2179234380623300629L;

	BlogService blogService = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		writeBlogs(response);
	}

	private void writeBlogs(ServletResponse response) throws IOException {
		blogService = BlogServiceImpl.getInstance();
		List<Blog> allBlogs = blogService.getAllBlogs();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("tr.border_bottom td {");
		out.println("border-bottom:1pt solid black;");
		out.println("}");
		out.println("</style>");
		out.println("<title>All blogs</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<table  style=\"width:100%\" align=\"center\">");
		out.println("<tr>");
		out.println("<th align=\"left\">Blogs</th>");
		out.println("</tr>");
		out.println("<br><br>");
		for (Blog blog : allBlogs) {
			out.println("<tr>");
			out.println("<td align=\"left\">" + blog.getTitle() + "</td>");
			out.println("</tr>");
			out.println("<tr class=\"border_bottom\">");
			out.println("<td align=\"center\">" + blog.getContent() + "</td>");
			out.println("</tr>");
			out.println("<br>");
		}
		out.println("</table");
		out.println("</body>");
		out.println("</html>");
	}
}
