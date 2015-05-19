package rs.pstech.workshop.javaweb.blog.dao;

import java.util.List;

import rs.pstech.workshop.javaweb.blog.model.Comment;

public interface CommentDao {

	public List<Comment> getBlogComments(Long blogId);

	public Comment getComment(Long commentId);

	public Long createComment(Long blogId, Comment comment);

	public void deleteComment(Long commentId);
}
