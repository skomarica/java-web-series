package rs.pstech.workshop.javaweb.blog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import rs.pstech.workshop.javaweb.blog.dao.BlogDao;
import rs.pstech.workshop.javaweb.blog.dao.CommentDao;
import rs.pstech.workshop.javaweb.blog.model.Blog;
import rs.pstech.workshop.javaweb.blog.model.Comment;

public class BlogServiceImpl implements BlogService {

	Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

	protected BlogDao blogDao;

	protected CommentDao commentDao;

	@Override
	@Transactional(readOnly = true)
	public Blog getBlog(Long id) {
		return blogDao.getBlog(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Blog> getAllBlogs() {
		return blogDao.getAllBlogs();
	}

	@Override
	@Transactional
	public Blog createBlog(Blog blog) {
		Long blogId = blogDao.createBlog(blog);

		if (logger.isDebugEnabled())
			logger.debug("Created new blog with ID '{}'", blogId);

		return blogDao.getBlog(blogId);
	}

	@Override
	@Transactional
	public void deleteBlog(Long blogId) {
		blogDao.deleteBlog(blogId);
	}

	@Override
	@Transactional
	public Comment addBlogComment(Long blogId, Comment comment) {
		Long commentId = commentDao.createComment(blogId, comment);

		return commentDao.getComment(commentId);
	}

	@Override
	@Transactional
	public void removeBlogComment(Long commentId) {
		commentDao.deleteComment(commentId);
	}

	// Setters & Getters
	public BlogDao getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

}
