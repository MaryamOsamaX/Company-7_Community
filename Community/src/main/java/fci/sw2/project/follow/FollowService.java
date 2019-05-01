package fci.sw2.project.follow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowService {
	@Autowired
	private FollowRepository followRepo;
	
	public Follow follow(Fkey key)
	{
		if(!followRepo.findById(key).isPresent())
		{
			 Follow v=new Follow();
			 v.setKey(key);
		     followRepo.save(v);
		     return v;
		}
		return null;
	}
	public Boolean unFollow(Fkey key)
	{
		if(followRepo.findById(key).isPresent())
		{
			System.out.println("deletef");
			followRepo.deleteById(key);
		     return true;
		}
		return false;
	}
	public List<Follow> getAllFollowersByUserId(String userId)
	{ 
		List<Follow> filtered=followRepo.findAllByKeyFollowedId(userId);
		return filtered;
		
	}
	public List<Follow> getAllFollowedByUserId(String userId)
	{ 
		List<Follow> filtered=followRepo.findAllByKeyFollowerId(userId);
		return filtered;
	}
	 
}

