package rs.pstech.workshop.javaweb.blog.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rs.pstech.workshop.javaweb.blog.model.Blog;

public class BlogServiceImpl implements BlogService {

	Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

	private static final String SELECT_STATEMENT = "select blog_id,title,content from blog";

	private static final String INSERT_STATEMENT = "insert into blog (title,content) values (?,?)";

	private String propFileName = "blog/config.properties";

	private Properties props = new Properties();

	private static BlogServiceImpl instance;

	public static BlogServiceImpl getInstance() throws IOException {
		if (instance == null) {
			instance = new BlogServiceImpl();
			instance.init();
		}
		return instance;
	}

	private Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = props.getProperty("jdbc.url");
		String user = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		String driver = props.getProperty("jdbc.driver");
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}

	@Override
	public List<Blog> getAllBlogs() {
		List<Blog> blogs = new ArrayList<Blog>();
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_STATEMENT);
			ResultSet rs = prepareStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("blog_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Blog blog = new Blog();
				blog.setBlog_id(id);
				blog.setTitle(title);
				blog.setContent(content);
				blogs.add(blog);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			logger.error("Unexpected exception during selection of blogs. " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				}
				catch (SQLException e) {
					logger.error("Unexpected exception while closing connection. " + e.getMessage());
				}
			}
		}
		return blogs;
	}

	@Override
	public Blog createBlog(Blog blog) {
		Connection connection = null;
		try {
			connection = getConnection();

			PreparedStatement stmt = connection.prepareStatement(INSERT_STATEMENT,
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, blog.getTitle());
			stmt.setString(2, blog.getContent());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			long pk = rs.getLong(1);
			blog.setBlog_id(pk);
		}
		catch (ClassNotFoundException | SQLException e) {
			logger.error("Unexpected exception during insertion of blogs. " + e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				}
				catch (SQLException e) {
					logger.error("Unexpected exception while closing connection. " + e.getMessage());
				}
			}
		}
		return blog;
	}

	private void init() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (inputStream != null) {
			props.load(inputStream);
		}
		else {
			logger.error("property file '" + propFileName + "' not found in the classpath");
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
	}

	public static void main(String[] args) {
		try {
			BlogServiceImpl instance = BlogServiceImpl.getInstance();
			Blog blog = new Blog();
			blog.setContent("nekakav sadrzaj");
			blog.setTitle("nekakav title");
			instance.createBlog(blog);
			List<Blog> allBlogs = instance.getAllBlogs();
			for (Blog blog2 : allBlogs) {
				System.out.println(blog2);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
