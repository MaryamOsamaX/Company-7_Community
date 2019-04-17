package fci.sw2.project.vote;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Key implements Serializable{
	private String  postId , userId;

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
	

}
