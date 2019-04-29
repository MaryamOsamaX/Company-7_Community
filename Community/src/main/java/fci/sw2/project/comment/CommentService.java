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

	public Comment makeComment(Comment c) {
		if (!commentRepo.findById(c.getCommentId()).isPresent()) {
			commentRepo.save(c);
			return c;
		}
		return null;
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

	/*public Comment updateComment(Comment comment) {
		if (commentRepo.findById(comment.getCommentId()).isPresent()) {

			commentRepo.save(comment);
			return comment;
		}
		return null;
	}
	
	public Boolean deleteComment(String commentId) {
		if (commentRepo.findById(commentId).isPresent()) {

			commentRepo.deleteById(commentId);
			return true;
		}
		return false;
	}*/
	public List<Comment> getAllCommentsForPost(String postId)
	{ 
		List<Comment> filtered=new ArrayList<Comment>();
		filtered=commentRepo.findAllByPostId(postId);
		return filtered;
	}
	
}
