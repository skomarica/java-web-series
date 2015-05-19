package rs.pstech.workshop.javaweb.blog.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rs.pstech.workshop.javaweb.blog.dao.BlogDao;
import rs.pstech.workshop.javaweb.blog.dao.CommentDao;
import rs.pstech.workshop.javaweb.blog.model.Blog;

public class BlogServiceTest {

	@InjectMocks
	private BlogServiceImpl blogService;

	@Mock
	private BlogDao blogDao;

	@Mock
	private CommentDao commentDao;

	private Blog blog1, blog2, blog3;

	private List<Blog> allBlogsList;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		Calendar c = Calendar.getInstance();

		c.clear();

		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, 5);
		c.set(Calendar.DAY_OF_MONTH, 1);

		blog1 = new Blog();
		blog1.setId(1L);
		blog1.setTitle("Title 1");
		blog1.setContent("Content 1...");
		blog1.setCreated(c.getTime());

		c.set(Calendar.DAY_OF_MONTH, 2);
		blog2 = new Blog();
		blog2.setId(2L);
		blog2.setTitle("Title 2");
		blog2.setContent("Content 2...");
		blog2.setCreated(c.getTime());

		c.set(Calendar.DAY_OF_MONTH, 3);
		blog3 = new Blog();
		blog3.setId(3L);
		blog3.setTitle("Title 3");
		blog3.setContent("Content 3...");
		blog3.setCreated(c.getTime());

		allBlogsList = Arrays.asList(new Blog[] { blog1, blog2, blog3 });
	}

	@Test
	public void testGetBlog() {
		when(blogDao.getBlog(1L)).thenReturn(blog1);
		Blog blog = blogService.getBlog(1L);
		assertEquals(blog1, blog);
	}

	@Test
	public void testGetAllBlogs() {
		when(blogDao.getAllBlogs()).thenReturn(allBlogsList);
		List<Blog> allBlogs = blogService.getAllBlogs();
		assertEquals(allBlogsList, allBlogs);
	}

	@Test
	public void testCreateBlog() {
		Blog newBlog = new Blog();
		newBlog.setTitle("New Title");

		Blog savedBlog = new Blog();
		savedBlog.setId(5L);
		savedBlog.setTitle("New Title");

		when(blogDao.createBlog(newBlog)).thenReturn(5L);
		when(blogDao.getBlog(5L)).thenReturn(savedBlog);

		Blog result = blogService.createBlog(newBlog);
		assertEquals(savedBlog, result);
	}

	@Test
	public void testDeleteBlog() {
		// TODO Implement
	}

	@Test
	public void testAddBlogComment() {
		// TODO Implement
	}

	@Test
	public void testRemoveBlogComment() {
		// TODO Implement
	}

}
