package fci.sw2.project.post;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<Post, String> {

	List<Post> findAllByUserId(String userId);
	
/*	@Modifying
	@Query("Update a FROM Post  WHERE a.postId=:x.postId Set a.title=:x.title and a.content=:x.content and a.privacy=:x.privacy and a.field=:x.field")
	Boolean update(@Param("x") Post p);*/
}
