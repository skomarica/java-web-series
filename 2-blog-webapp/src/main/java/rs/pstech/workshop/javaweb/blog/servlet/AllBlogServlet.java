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
		out.println("<title>Blog Application</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<div style=\"width: 60%; margin: 0 auto;\">");
		out.println("		<div style=\"width: 100% border-style: solid; border-bottom: solid; border-width: thin; margin-top: 20px; margin-bottom: 10px;\">");
		out.println("			<h3 style=\"font-weight: normal;\">");
		out.println("				Blogs");
		out.println("				<div align=\"right\">");
		out.println("					<a href=\"/blog2/create\" title=\"Create Blog\">Create Blog</a>");
		out.println("				</div>");
		out.println("			</h3>");
		out.println("		</div>");
		if (allBlogs == null || allBlogs.isEmpty()) {
			out.println("		<div>No blogs</div>");
		}
		else {
			for (Blog blog : allBlogs) {
				out.println("		<div>");
				out.println("			<h3>" + blog.getTitle() + "</h3>");
				out.println("		</div>");
				out.println("		<div style=\"border-bottom: solid; border-width: thin;\">" + blog.getContent()
						+ "</div>");
			}
		}
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
