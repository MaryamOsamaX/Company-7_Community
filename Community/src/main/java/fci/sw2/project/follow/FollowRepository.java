package fci.sw2.project.follow;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FollowRepository extends CrudRepository<Follow, Fkey>{

	List<Follow> findAllByKeyFollowerId(String followerId);
	List<Follow> findAllByKeyFollowedId(String followedId);
    // Follow deleteByKey(Fkey k);
}
