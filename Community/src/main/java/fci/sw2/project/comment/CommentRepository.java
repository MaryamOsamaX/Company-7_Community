package fci.sw2.project.comment;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, String>{

	
	List<Comment> findAllByPostId(String postId);
	Boolean deleteByCommentId(String commentId);
	
	
    
}
