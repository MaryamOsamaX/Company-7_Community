package fci.sw2.project.vote;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VoteController {
	
	@Autowired
	private VoteService voteService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = { "/voteUp" })
	public String voteUp(HttpServletRequest request, Model model) {
		String postId = request.getParameter("id");
		Key key=new Key();
		key.setPostId(postId); 
		key.setUserId("init");/**************HERE****************/
		voteService.votePost(key, "up");
		return "redirect:/home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = { "/voteDown" })
	public String voteDown(HttpServletRequest request, Model model) {
		String postId = request.getParameter("id");
		Key key=new Key();
		key.setPostId(postId); 
		key.setUserId("init");/**************HERE****************/
		voteService.votePost(key, "down");
		return "redirect:/home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = { "/deleteVote" })
	public String deleteVote(HttpServletRequest request, Model model) {
		String postId = request.getParameter("id");
		String type=request.getParameter("type");
		System.out.println(type);
		Key key=new Key();
		key.setPostId(postId); 
		key.setUserId("init");/**************HERE****************/
		voteService.deleteVote(key,type);
		return "redirect:/home";
	}
	

}
