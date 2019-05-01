package fci.sw2.project.test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;




import fci.sw2.project.vote.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class VoteServiceTest {
	 
	@InjectMocks
	private VoteService vs;
	
	@Mock
     VoteRepository vrMock;
    
	/*@Test
    public void votePost()
    {
		Key k=new Key("0","init");
		System.out.println(vs.votePost(k, "up"));
    }*/
	
	
	
}
