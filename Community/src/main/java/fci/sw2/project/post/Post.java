package fci.sw2.project.post;

import javax.persistence.*;

@Entity
public class Post {
	private String postId , userId , title , content ,privacy , field;
	private int numOfVotesUp , numOfVotesDown;
	
	@Id
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public Post(){}
	public Post(String postId, String userId, String title, String content, String privacy, String field,
			int numOfVotesUp, int numOfVotesDown) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.privacy = privacy;
		this.field = field;
		this.numOfVotesUp = numOfVotesUp;
		this.numOfVotesDown = numOfVotesDown;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public int getNumOfVotesUp() {
		return numOfVotesUp;
	}
	public void setNumOfVotesUp(int numOfVotesUp) {
		this.numOfVotesUp = numOfVotesUp;
	}
	public int getNumOfVotesDown() {
		return numOfVotesDown;
	}
	public void setNumOfVotesDown(int numOfVotesDown) {
		this.numOfVotesDown = numOfVotesDown;
	}
	
	

}
