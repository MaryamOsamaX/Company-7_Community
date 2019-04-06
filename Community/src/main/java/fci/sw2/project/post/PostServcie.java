package fci.sw2.project.post;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PostService {
	static int id=0;
	@Autowired
	private PostRepository postRepo;

	public void makePost(Post post) {
		if (!postRepo.findById(post.getPostId()).isPresent()) {
			postRepo.save(post);
		}
	}
	public void initialId(Post p)
	{
		//increase the id if it's already exists
		while(postRepo.findById(String.valueOf(id)).isPresent()) 	
		{
			id++;
		}
		p.setPostId(String.valueOf(id));
		id++;
	}
	
	public Post getPostById(String id)
	{
		Post post = new Post();
		if (postRepo.findById(id).isPresent()) {
			post = postRepo.findById(id).get();
			return post;
		} else {
			return null;
		}
	}

	public void updatePost(Post post) {
		if (postRepo.findById(post.getPostId()).isPresent()) {

			postRepo.save(post);
		}
	}
	
	public void deletePost(String postId) {
		if (postRepo.findById(postId).isPresent()) {

			postRepo.deleteById(postId);
		}
	}
}
