package rs.pstech.workshop.javaweb.blog.servlet;

import java.io.IOException;

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
		response.sendRedirect("blogs");
	}

	private void saveBlog(HttpServletRequest request) throws IOException {
		blogService = BlogServiceImpl.getInstance();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setContent(content);
		blog = blogService.createBlog(blog);
	}
}
