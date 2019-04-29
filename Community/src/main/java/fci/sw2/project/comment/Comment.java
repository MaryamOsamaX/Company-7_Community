package fci.sw2.project.comment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {
	private String postId , userId , commentId , content;
	
	public Comment(){}

	public Comment(String postId, String userId, String commentId, String content) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.commentId = commentId;
		this.content = content;
	}

	@Id
	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	
	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	  @Override
	    public String toString() { 
	        return String.format(postId+" "+userId+" "+commentId+" "+content); 
	    } 
}
