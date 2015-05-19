package rs.pstech.workshop.javaweb.blog.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rs.pstech.workshop.javaweb.blog.dao.BlogDao;
import rs.pstech.workshop.javaweb.blog.model.Blog;

public class BlogDaoImpl implements BlogDao {

	Logger logger = LoggerFactory.getLogger(BlogDaoImpl.class);

	protected SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Blog> getAllBlogs() {
		return (List<Blog>) sessionFactory.getCurrentSession().createQuery("from Blog order by created").list();
	}

	@Override
	public Blog getBlog(Long blogId) {
		return (Blog) sessionFactory.getCurrentSession().get(Blog.class, blogId);
	}

	@Override
	public Long createBlog(Blog blog) {
		return (Long) sessionFactory.getCurrentSession().save(blog);
	}

	@Override
	public void deleteBlog(Long blogId) {
		sessionFactory.getCurrentSession().delete(getBlog(blogId));
	}

	// Setters & Getters
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
