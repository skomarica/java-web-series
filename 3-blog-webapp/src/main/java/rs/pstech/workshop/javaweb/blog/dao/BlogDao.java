package rs.pstech.workshop.javaweb.blog.dao;

import java.util.List;

import rs.pstech.workshop.javaweb.blog.model.Blog;

public interface BlogDao {

	public List<Blog> getAllBlogs();

	public Blog getBlog(Long blogId);

	public Long createBlog(Blog blog);

	public void deleteBlog(Long blogId);

}
