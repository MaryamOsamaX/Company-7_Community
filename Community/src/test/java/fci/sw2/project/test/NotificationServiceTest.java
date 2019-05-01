package fci.sw2.project.test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import fci.sw2.project.notification.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class NotificationServiceTest {

	@InjectMocks
	private NotificationService ns=new NotificationService();

	@Mock
	NotificationRepository nrMock;

	

	@Test
	public void getAllNotificationsByUserId() {
		String userId = "init";
		List<Notification> r = new ArrayList<Notification>();
		r.add(new Notification("0", "init", "0", "3", System.currentTimeMillis()));
		r.add(new Notification("1", "init", "2", "4", System.currentTimeMillis()));

		when(nrMock.findAllByFollowerId(userId)).thenReturn(r);
		assertEquals(r.size(), ns.getAllNotificationsByUserId(userId).size());

	}

	@Test
	public void initialId() {
		Notification r = new Notification("00", "init" , "0" ,"5", System.currentTimeMillis());
		System.out.println(ns.initialId(r));
		assertEquals(2, ns.initialId(r));
        
	}
	
	@Test
	public void makeNotification()
	{
		//List<Notification>x=new ArrayList<Notification>();
		//nrMock.findAll().forEach(x::add);
		//System.out.println(x.size());
		/********************************/
	//	System.out.println(ns.makeNotification("init", "2").size());
		System.out.println(nrMock.findAllByCreator("init").size());
		/*assertEquals(ns.makeNotification("init", "2").size(), 
				nrMock.findAllByCreator("init").size());*/
	}

}
