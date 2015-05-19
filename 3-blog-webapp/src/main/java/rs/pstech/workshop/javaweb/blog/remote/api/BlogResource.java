package rs.pstech.workshop.javaweb.blog.remote.api;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.pstech.workshop.javaweb.blog.model.Blog;
import rs.pstech.workshop.javaweb.blog.model.Comment;
import rs.pstech.workshop.javaweb.blog.service.BlogService;

@RestController
@RequestMapping(value = "/blog")
public class BlogResource {

	Logger logger = LoggerFactory.getLogger(BlogResource.class);

	protected BlogService blogService;

	// Blog API
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Blog> getAllBlogs() {
		return blogService.getAllBlogs();
	}

	@RequestMapping(value = "/{blogId}/data", method = RequestMethod.GET)
	public @ResponseBody Blog getBlog(@PathVariable("blogId") Long blogId) {
		return blogService.getBlog(blogId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Blog createBlog(@RequestBody Blog blog) {
		blog.setCreated(new Date());

		return blogService.createBlog(blog);
	}

	@RequestMapping(value = "/{blogId}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteBlog(@PathVariable("blogId") Long blogId) {
		blogService.deleteBlog(blogId);
	}

	// Comments API
	@RequestMapping(value = "/{blogId}/comment", method = RequestMethod.POST)
	public @ResponseBody Comment createComment(@PathVariable("blogId") Long blogId, @RequestBody Comment comment) {
		comment.setCreated(new Date());

		return blogService.addBlogComment(blogId, comment);
	}

	@RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteBlogComment(@PathVariable("commentId") Long commentId) {
		blogService.removeBlogComment(commentId);
	}

	// Setters & Getters
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

}
