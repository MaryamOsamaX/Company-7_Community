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

import fci.sw2.project.follow.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowServiceTest {

	@InjectMocks
	private FollowService fS;

	@Mock
	FollowRepository frMock;
	@Rule
	public ExpectedException exc = ExpectedException.none();
/*
	@Test
	public void getAllFollowersByUserId() {
		String userId = "0";
		List<Follow> r = new ArrayList<Follow>();
		r.add(new Follow(new Fkey("1","0")));
		r.add(new Follow(new Fkey("2","0")));
		r.add(new Follow(new Fkey("3","0")));
		when(frMock.findAllByFollowedId(userId)).thenReturn(r);
		//System.out.println(crMock.findAllByPostId(postId).size());
		//System.out.println(cS.getAllCommentsForPost(postId).size());
		assertEquals(r.size(), fS.getAllFollowersByUserId(userId).size());

	}

	@Test
	public void getAllFollowedByUserId() {
		String userId = "0";
		List<Follow> r = new ArrayList<Follow>();
		r.add(new Follow(new Fkey("0","01")));
		when(frMock.findAllByFollowerId(userId)).thenReturn(r);
		//System.out.println(crMock.findAllByPostId(postId).size());
		//System.out.println(cS.getAllCommentsForPost(postId).size());
		assertEquals(r.size(), fS.getAllFollowedByUserId(userId).size());

	}

	@Test
	public void follow() {
		Follow c=new Follow(new Fkey("0","01"));
		when(frMock.save(c)).thenReturn(c);
		assertEquals(c, fS.follow(c.getKey()));
	}*/

}

