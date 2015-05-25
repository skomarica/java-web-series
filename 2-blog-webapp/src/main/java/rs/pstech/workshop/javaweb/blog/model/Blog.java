package rs.pstech.workshop.javaweb.blog.model;

import java.io.Serializable;

public class Blog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private String content;

	public Blog() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

}
