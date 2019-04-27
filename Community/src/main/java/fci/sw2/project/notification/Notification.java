package fci.sw2.project.notification;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Notification {
	private String notificationId;
	private String followerId;
	private String creator;
	private String postId;
	private long date;
	@Id
	public String getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	public String getFollowerId() {
		return followerId;
	}
	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	} 
	public long getDate() {
		return date;
	}
/*	public void setDate(long date) {
		this.date = date;
	}*/
	public void setDate(long currentTimeMillis) {
		this.date = currentTimeMillis;
		
	}
	
	
}
