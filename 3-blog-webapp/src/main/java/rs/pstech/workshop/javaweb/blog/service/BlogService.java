package rs.pstech.workshop.javaweb.blog.service;

import java.util.List;

import rs.pstech.workshop.javaweb.blog.model.Blog;
import rs.pstech.workshop.javaweb.blog.model.Comment;

public interface BlogService {

	public Blog getBlog(Long id);

	public List<Blog> getAllBlogs();

	public void deleteBlog(Long blogId);

	public Blog createBlog(Blog blog);

	public Comment addBlogComment(Long blogId, Comment comment);

	public void removeBlogComment(Long commentId);
}
