package rs.pstech.workshop.javaweb.blog.model;

import java.io.Serializable;

public class Blog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long blog_id;

	private String title;

	private String content;

	public Blog() {
		super();
	}

	public Long getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(Long blog_id) {
		this.blog_id = blog_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Blog [blog_id=" + blog_id + ", title=" + title + ", content=" + content + "]";
	}

}
