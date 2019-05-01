package fci.sw2.project.home;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fci.sw2.project.follow.*;
import fci.sw2.project.post.*;

@Service
public class HomeService {
	@Autowired
	private FollowService followService;
	@Autowired
	private PostService postService;
	
	public List<Post> getHome( String myId , String myType)
	{
		List<Post> all=new ArrayList<Post>();
		List<Post> filtered=new ArrayList<Post>();
		List<Follow> followed=new ArrayList<Follow>();
		///add my posts
        filtered.addAll(postService.getAllPostsByUserId(myId));
		///Get all the followed for me
		followed=followService.getAllFollowedByUserId(myId);
		///Get all posts for followed people
		for(int i=0 ; i<followed.size() ; i++)
		{
			all.addAll(postService.getAllPostsByUserId(followed.get(i).getKey().getFollowedId()));
		}
		///filter posts by privacy
		for(int i=0 ; i<all.size();i++)
		{
			if(all.get(i).getPrivacy().equals("public")||
			   all.get(i).getPrivacy().equals(myType))
			{
				filtered.add(all.get(i));
			}
		}
		return filtered;
	}

}
