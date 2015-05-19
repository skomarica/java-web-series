package rs.pstech.workshop.javaweb.blog.dao.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CommentDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetBlogComments() {
		// TODO Implement
	}

	@Test
	public void testGetComment() {
		// TODO Implement
	}

	@Test
	public void testCreateComment() {
		// TODO Implement
	}

	@Test
	public void testDeleteComment() {
		// TODO Implement
	}

}
