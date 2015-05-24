package rs.pstech.workshop.javaweb.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.pstech.workshop.javaweb.blog.model.Blog;
import rs.pstech.workshop.javaweb.blog.service.BlogService;
import rs.pstech.workshop.javaweb.blog.service.BlogServiceImpl;

public class CreateBlogServlet extends HttpServlet {

	private static final long serialVersionUID = 561731399261100579L;

	BlogService blogService = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		saveBlog(request);
		response.sendRedirect("");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Blog Application</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div style=\"width: 60%; margin: 0 auto;\">");
		out.println("<div style=\"width: 100% border-style: solid; border-bottom: solid; border-width: thin; margin-top: 20px; margin-bottom: 10px;\">");
		out.println("<h3 style=\"font-weight: normal;\">Create new blog</h3>");
		out.println("</div>");
		out.println("<form id=\"blog\" action=\"create\" method=\"POST\">");
		out.println("<div style=\"width: 80%; margin: 0 auto;\">");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td width=\"20%\" align=\"right\" valign=\"top\"><label>Title</label></td>");
		out.println("<td width=\"10%\">");
		out.println("<td width=\"70%\" align=\"left\"><input type=\"text\" id=\"title\" name=\"title\" placeholder=\"Title\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=\"20%\" align=\"right\" valign=\"top\"><label>Content</label></td>");
		out.println("<td width=\"10%\">");
		out.println("<td width=\"70%\" align=\"left\"><textarea rows=\"4\" cols=\"50\" name=\"content\" id=\"content\" placeholder=\"Content\"></textarea></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=\"20%\" align=\"right\" valign=\"top\"></td>");
		out.println("<td width=\"10%\">");
		out.println("<td width=\"70%\" align=\"left\"><input type=\"submit\" value=\"Save\"></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	private void saveBlog(HttpServletRequest request) throws IOException {
		blogService = BlogServiceImpl.getInstance();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if (title != null && !title.isEmpty() && content != null && !content.isEmpty()) {
			Blog blog = new Blog();
			blog.setTitle(title);
			blog.setContent(content);
			blog = blogService.createBlog(blog);
		}
	}
}
