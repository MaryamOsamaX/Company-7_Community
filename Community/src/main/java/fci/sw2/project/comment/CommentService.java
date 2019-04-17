package fci.sw2.project.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
	static int id=0;
	@Autowired
	private CommentRepository commentRepo;

	public void makeComment(Comment c) {
		if (!commentRepo.findById(c.getCommentId()).isPresent()) {
			commentRepo.save(c);
		}
	}
	public void initialId(Comment c)
	{
		//increase the id if it's already exists
		while(commentRepo.findById(String.valueOf(id)).isPresent()) 	
		{
			id++;
		}
		c.setCommentId(String.valueOf(id));
		id++;
	}
	
	public Comment getCommentById(String id)
	{
		Comment comment = new Comment();
		if (commentRepo.findById(id).isPresent()) {
			comment = commentRepo.findById(id).get();
			return comment;
		} else {
			return null;
		}
	}

	public void updateComment(Comment comment) {
		if (commentRepo.findById(comment.getPostId()).isPresent()) {

			commentRepo.save(comment);
		}
	}
	
	public void deleteComment(String commentId) {
		if (commentRepo.findById(commentId).isPresent()) {

			commentRepo.deleteById(commentId);
		}
	}
	public List<Comment> getAllCommentsForPost(String postId)
	{ 
		
		List<Comment> allComments=new ArrayList<Comment>();
		List<Comment> filtered=new ArrayList<Comment>();
		commentRepo.findAll().forEach(allComments::add);
		if(allComments.size()==0){
			//System.out.println("FOUNNNND"); 
		}
		for(int i=0 ; i<allComments.size(); i++) 
		{
			//System.out.println(allComments.get(i).getPostId());
			if(allComments.get(i).getPostId().equals(postId))
			{
				//System.out.println("**YES");
				filtered.add(allComments.get(i));
			}
		}
		
		return filtered;
	}
	
}
