package fci.sw2.project.test;



import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



import fci.sw2.project.post.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
	
	@InjectMocks
	private PostService ps; 
	
	@Mock
     PostRepository prMock;
    @Rule
	public ExpectedException exc=ExpectedException.none();
	
	@Test
	public void getAllPostsByUserId()
	{
		String userId="init";
		List<Post> r =new ArrayList<Post>();
		r.add(new Post("0","init","title1" ,"content1","public","gg",0,0));
		r.add(new Post("1","init","title2" ,"content2","public","gg",0,0));
		r.add(new Post("2","init","title3" ,"content3","public","gg",0,0));
		when(prMock.findAllByUserId(userId)).thenReturn(r);
		System.out.println(prMock.findAllByUserId(userId).size());
		System.out.println(ps.getAllPostsByUserId(userId).size());
		assertEquals(r.size() ,ps.getAllPostsByUserId(userId).size());
	
	}
	
	@Test
	public void getPostById()
	{
		String postId="0";
		exc.expect(NoSuchElementException.class);
		Post c=new Post("0","init","title1" ,"content1","public","gg",0,0);
		when(prMock.findById(postId).get()).thenReturn(c);
		//System.out.println(c.toString() +"  "+cS.getCommentById(commentId).toString());
		assertEquals(c , ps.getPostById(postId));
			
	}
	
	@Test
	public void makePost()
	{
		Post c=new Post("4","init","DUmmy" ,"ccc","public","gg",0,0);
		when(prMock.save(c)).thenReturn(c);
		assertEquals(c , ps.makePost(c));	
	}
	/*@Test
	public void updatePost()
	{   String postId="0";
		Post c=new Post("0","init","DUmmy" ,"ccc","public","gg",0,0);
	    when(prMock.update(c)).thenReturn(true);
		assertEquals(true , ps.updatePost(c));	
		
	}*/
	
	

	
	
	
}
