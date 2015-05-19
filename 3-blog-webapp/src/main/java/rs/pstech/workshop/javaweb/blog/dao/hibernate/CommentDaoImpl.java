package rs.pstech.workshop.javaweb.blog.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rs.pstech.workshop.javaweb.blog.dao.BlogDao;
import rs.pstech.workshop.javaweb.blog.dao.CommentDao;
import rs.pstech.workshop.javaweb.blog.model.Blog;
import rs.pstech.workshop.javaweb.blog.model.Comment;

public class CommentDaoImpl implements CommentDao {

	Logger logger = LoggerFactory.getLogger(CommentDaoImpl.class);

	protected SessionFactory sessionFactory;

	protected BlogDao blogDao;

	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> getBlogComments(Long blogId) {
		Blog blog = blogDao.getBlog(blogId);

		Query query = sessionFactory.getCurrentSession().createQuery("from Comment where blog = ? order by created");
		query.setParameter(0, blog);

		return (List<Comment>) query.list();
	}

	public Comment getComment(Long commentId) {
		return (Comment) sessionFactory.getCurrentSession().get(Blog.class, commentId);
	}

	@Override
	public Long createComment(Long blogId, Comment comment) {
		Blog blog = blogDao.getBlog(blogId);

		comment.setBlog(blog);

		return (Long) sessionFactory.getCurrentSession().save(comment);
	}

	@Override
	public void deleteComment(Long commentId) {
		sessionFactory.getCurrentSession().delete(commentId);
	}

	// Setters & Getters
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public BlogDao getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

}
