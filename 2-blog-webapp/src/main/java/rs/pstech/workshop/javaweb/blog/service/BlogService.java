package rs.pstech.workshop.javaweb.blog.service;

import java.util.List;

import rs.pstech.workshop.javaweb.blog.model.Blog;

public interface BlogService {

	public List<Blog> getAllBlogs();

	public Blog createBlog(Blog blog);

}
