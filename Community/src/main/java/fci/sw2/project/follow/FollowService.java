package fci.sw2.project.follow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fci.sw2.project.notification.Notification;


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
	public List<Follow> getAllFollowersByUserId(String userId)
	{ 
		List<Follow> allfollowers=new ArrayList<Follow>();
		List<Follow> filtered=new ArrayList<Follow>();
		followRepo.findAll().forEach(allfollowers::add);
		for(int i=0 ; i<allfollowers.size(); i++)
		{
			if(allfollowers.get(i).getKey().getFollowedId().equals(userId))
			{
				filtered.add(allfollowers.get(i));
			}
			
		}
		//filtered.sort(descDate);
		return filtered;
	}
	public List<String> getAllFollowedByUserId(String userId)
	{ 
		List<Follow> allfollowed=new ArrayList<Follow>();
		List<String> filtered=new ArrayList<String>();
		followRepo.findAll().forEach(allfollowed::add);
		for(int i=0 ; i<allfollowed.size(); i++)
		{
			if(allfollowed.get(i).getKey().getFollowerId().equals(userId))
			{
				filtered.add(allfollowed.get(i).getKey().getFollowedId());
			}
			
		}
		return filtered;
	}
}

