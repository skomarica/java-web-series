package rs.pstech.workshop.javaweb.blog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class Blog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "blog_id")
	@GeneratedValue
	private Long id;

	@Column
	private String title;

	@Column(length = 1000)
	private String content;

	@Column
	private String author;

	@Column
	private Date created;

	@OneToMany(mappedBy = "blog", fetch = FetchType.EAGER)
	private Set<Comment> comments = new HashSet<Comment>();

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

	public String getAuthor() {
		return author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", created="
				+ created + ", comments=" + comments + "]";
	}

}
