package fci.sw2.project.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fci.sw2.project.post.Post;
import fci.sw2.project.post.PostService;

@Service
public class VoteService {
	
	
	//private PostRepository postRepo;
	@Autowired
	private PostService postService;
	@Autowired
	private VoteRepository voteRepo;
	
	public boolean votePost(Key key, String type)
	{
		if(!voteRepo.findById(key).isPresent()) 
		{
			try{
			Post p=new Post();
			Vote v=new Vote();
			v.setKey(key);
		 	p=postService.getPostById(key.getPostId());
			if(type.equals("up"))
			{
				p.setNumOfVotesUp(p.getNumOfVotesUp()+1);
		       
			}
			else
			{
				p.setNumOfVotesDown(p.getNumOfVotesDown()+1);
		            
			}
			postService.updatePost(p);
			// postRepo.save(p);
		     voteRepo.save(v);
		     return true;
		}
		catch(Exception e){}}
		return false;
	}
	
	public boolean deleteVote(Key key, String type)
	{
		if(voteRepo.findById(key).isPresent())
		{
			Post p=new Post();
			Vote v=new Vote();
			v.setKey(key);
			//p=postRepo.findById(key.getPostId()).get();
			p=postService.getPostById(key.getPostId());
			if(type.equals("up"))
			{
				p.setNumOfVotesUp(p.getNumOfVotesUp()-1);
		       
			}
			else
			{
				p.setNumOfVotesDown(p.getNumOfVotesDown()-1);
		            
			}
			 //postRepo.save(p);
			postService.updatePost(p);
		     voteRepo.delete(v);
		     return true;
		}
		return false;
	}
	
	

}
