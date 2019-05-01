package fci.sw2.project.notification;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationRepository extends CrudRepository<Notification,String> {
 
	List<Notification> findAllByFollowerId(String followerId);
	List<Notification> findAllByCreator(String creator);
	
	
}
