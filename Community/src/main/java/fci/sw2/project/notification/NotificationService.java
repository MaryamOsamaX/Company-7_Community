package fci.sw2.project.notification;


//package fci.sw2.project.follow;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fci.sw2.project.follow.Follow;
import fci.sw2.project.follow.FollowService;
import fci.sw2.project.post.Post;

@Service
public class NotificationService {
	static int id = 0;
	@Autowired
	private NotificationRepository notifyRepo;
	@Autowired
	private FollowService fs;
	static private Comparator<Notification> descDate;

	// We initialize static variables inside a static block.
	static {
		descDate = new Comparator<Notification>() {
			@Override
			public int compare(Notification b1, Notification b2) {
				return Long.compare(b1.getDate(), b2.getDate());
			}
		};
	}

	public int initialId(Notification p) {
		// increase the id if it's already exists
		while (notifyRepo.findById(String.valueOf(id)).isPresent()) {
			id++;
		}
		p.setNotificationId(String.valueOf(id));
		id++;
		return id;
	}
	
	

	public List<Notification> makeNotification(String followedId, String postId) {
		List<Follow> all = fs.getAllFollowersByUserId(followedId);
		List<Notification> nn=new ArrayList<Notification>();
		if (all.size() != 0) {
			for (int i = 0; i < all.size(); i++) {
				Notification n = new Notification();
				n.setDate(System.currentTimeMillis());
				n.setCreator(followedId);
				n.setFollowerId(all.get(i).getKey().getFollowerId());
				n.setPostId(postId);
				initialId(n);
				if (!notifyRepo.findById(n.getNotificationId()).isPresent()) {
					notifyRepo.save(n);
					nn.add(n);
				}
			}
		}
		return nn;
	}

	public List<Notification> getAllNotificationsByUserId(String userId) {
		//List<Notification> all = new ArrayList<Notification>();
		List<Notification> filtered = new ArrayList<Notification>();
		filtered=notifyRepo.findAllByFollowerId(userId);
		filtered.sort(descDate);
		return filtered;
	}

	
}
