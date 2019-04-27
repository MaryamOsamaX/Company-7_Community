package fci.sw2.project.notification;


//package fci.sw2.project.follow;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fci.sw2.project.follow.Follow;
import fci.sw2.project.follow.FollowService;

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
				/*
				 * long d1 = b1.getDate().getTime(); long d2 =
				 * b2.getDate().getTime(); return Long.compare(d1, d2);
				 */
				return Long.compare(b1.getDate(), b2.getDate());
			}
		};
	}

	public void initialId(Notification p) {
		// increase the id if it's already exists
		while (notifyRepo.findById(String.valueOf(id)).isPresent()) {
			id++;
		}
		p.setNotificationId(String.valueOf(id));
		id++;
	}

	public void makeNotification(String followedId, String postId) {
		List<Follow> all = fs.getAllFollowersByUserId(followedId);
		if (all.size() != 0) {
			for (int i = 0; i < all.size(); i++) {
				Notification n = new Notification();
				// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd
				// HH:mm:ss");
				// Date date = new Date();
				n.setDate(System.currentTimeMillis());
				n.setCreator(followedId);
				n.setFollowerId(all.get(i).getKey().getFollowerId());
				// n.setNotificationId(String.valueOf(id));
				n.setPostId(postId);
				initialId(n);
				// id++;
				if (!notifyRepo.findById(n.getNotificationId()).isPresent()) {
					notifyRepo.save(n);
				}
			}
		}
	}

	public List<Notification> getAllPostsByUserId(String userId) {
		List<Notification> allPosts = new ArrayList<Notification>();
		List<Notification> filtered = new ArrayList<Notification>();
		notifyRepo.findAll().forEach(allPosts::add);
		for (int i = 0; i < allPosts.size(); i++) {
			if (allPosts.get(i).getFollowerId().equals(userId)) {
				filtered.add(allPosts.get(i));
			}

		}
		filtered.sort(descDate);
		return filtered;
	}

	
}
