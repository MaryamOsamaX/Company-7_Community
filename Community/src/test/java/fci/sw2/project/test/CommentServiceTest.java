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

import fci.sw2.project.comment.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

	@InjectMocks
	private CommentService cS;

	@Mock
	CommentRepository crMock;
	@Rule
	public ExpectedException exc = ExpectedException.none();

	@Test
	public void testGetAllCommentsForPost() {
		String postId = "0";
		List<Comment> r = new ArrayList<Comment>();
		r.add(new Comment("0", "z", "0", "content1"));
		r.add(new Comment("0", "x", "1", "content2"));
		r.add(new Comment("0", "yy", "2", "content3"));
		when(crMock.findAllByPostId(postId)).thenReturn(r);
		System.out.println(crMock.findAllByPostId(postId).size());
		System.out.println(cS.getAllCommentsForPost(postId).size());
		assertEquals(r.size(), cS.getAllCommentsForPost(postId).size());

	}

	@Test
	public void getCommentById() {
		String commentId = "0";
		exc.expect(NoSuchElementException.class);
		Comment c = new Comment("0", "z", "0", "content1");
		when(crMock.findById(commentId).get()).thenReturn(c);
		assertEquals(c, cS.getCommentById(commentId));

	} 

	@Test
	public void makeComment() {
		Comment c = new Comment("1", "c", "3", "content4");
		when(crMock.save(c)).thenReturn(c);
		assertEquals(c, cS.makeComment(c));
	}

}
