package rs.pstech.workshop.javaweb.blog.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import rs.pstech.workshop.javaweb.blog.model.Blog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class BlogDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	Logger logger = LoggerFactory.getLogger(BlogDaoTest.class);

	public static final String TABLE_BLOG = "blog";

	public static final String SQL_BLOG_INSERT = "INSERT INTO blog (blog_id, title, content, author, created) VALUES (?, ?, ?, ?, ?)";

	public static final String SQL_BLOG_SELECT_BY_TITLE = "SELECT blog_id FROM blog WHERE title = ?";

	public static final String SQL_BLOG_DELETE_BY_ID = "DELETE FROM blog WHERE blog_id = ?";

	@Autowired
	private BlogDaoImpl blogDao;

	@Autowired
	private SessionFactory sessionFactory;

	@BeforeTransaction
	public void beforeTransaction() {

		// Insert test blog entries

		Calendar c = Calendar.getInstance();

		c.clear();

		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, 5);
		c.set(Calendar.DAY_OF_MONTH, 1);

		jdbcTemplate.update(SQL_BLOG_INSERT, new Object[] { 1, "Title 1", "Content 1...", "User 1", c.getTime() });

		c.set(Calendar.DAY_OF_MONTH, 2);
		jdbcTemplate.update(SQL_BLOG_INSERT, new Object[] { 2, "Title 2", "Content 2...", "User 2", c.getTime() });

		c.set(Calendar.DAY_OF_MONTH, 3);
		jdbcTemplate.update(SQL_BLOG_INSERT, new Object[] { 3, "Title 3", "Content 3...", "User 3", c.getTime() });

	}

	@AfterTransaction
	public void afterTransaction() {

		// Delete test connections

		jdbcTemplate.update(SQL_BLOG_DELETE_BY_ID, new Object[] { 1 });
		jdbcTemplate.update(SQL_BLOG_DELETE_BY_ID, new Object[] { 2 });
		jdbcTemplate.update(SQL_BLOG_DELETE_BY_ID, new Object[] { 3 });
	}

	@Test
	public void testGetAllBlogs() {
		List<Blog> allBlogs = blogDao.getAllBlogs();
		assertEquals(3, allBlogs.size());

		// "Title 1" should be first if entries are ordered correctly
		assertEquals("Title 1", allBlogs.get(0).getTitle());
		assertEquals("Title 3", allBlogs.get(2).getTitle());
	}

	@Test
	public void testGetBlog() {
		Blog blog2 = blogDao.getBlog(2L);
		assertEquals("User 2", blog2.getAuthor());

		Blog blog4 = blogDao.getBlog(4L);
		assertNull(blog4);
	}

	@Test
	public void testCreateBlog() {
		Blog blog = new Blog();
		blog.setTitle("Title 5");
		blog.setContent("Content 5...");
		blog.setAuthor("User 5");

		Long blogId = blogDao.createBlog(blog);

		sessionFactory.getCurrentSession().flush();

		if (logger.isDebugEnabled())
			logger.debug("Created blog with ID '{}'", blogId);

		Long result = jdbcTemplate.queryForObject(SQL_BLOG_SELECT_BY_TITLE, new Object[] { "Title 5" }, Long.class);

		assertEquals(result, blogId);
	}

	@Test
	public void testDeleteBlog() {
		blogDao.deleteBlog(3L);

		sessionFactory.getCurrentSession().flush();

		assertEquals(2, countRowsInTable(TABLE_BLOG));
	}

}
