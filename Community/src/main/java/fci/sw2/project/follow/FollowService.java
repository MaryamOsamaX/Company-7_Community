package fci.sw2.project.follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowService {
	@Autowired
	private FollowRepository followRepo;
	
	public boolean follow(Fkey key)
	{
		if(!followRepo.findById(key).isPresent())
		{
			 Follow v=new Follow();
			 v.setKey(key);
		     followRepo.save(v);
		     return true;
		}
		return false;
	}
	public boolean unFollow(Fkey key)
	{
		if(followRepo.findById(key).isPresent())
		{
			System.out.println("deletef");
			Follow v=new Follow();
			v.setKey(key);
			followRepo.delete(v);
		     return true;
		}
		return false;
	}
}

