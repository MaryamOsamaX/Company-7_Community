package fci.sw2.project.follow;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Fkey implements Serializable {
	private String followerId,followedId;
	public String getFollowerId() {
		return followerId;
	}
	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}
	public String getFollowedId() {
		return followedId;
	}
	public void setFollowedId(String followedId) {
		this.followedId = followedId;
	}
}
