package fci.sw2.project.follow;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FollowController {

	@Autowired
	private FollowService followService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = { "/follow" })
	public String voteUp(HttpServletRequest request, Model model) {
		String ferId = request.getParameter("id1");
		String fedId = request.getParameter("id2");
		if(!ferId.equals(fedId)){
			Fkey key=new Fkey();
			key.setFollowerId(ferId);
			key.setFollowedId(fedId);
			followService.follow(key);
		}
		return "redirect:/home";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = { "/unfollow" })
	public String deleteVote(HttpServletRequest request, Model model) {
		String ferId = request.getParameter("id1");
		String fedId = request.getParameter("id2");
		if(!ferId.equals(fedId)){
			Fkey key=new Fkey();
			key.setFollowerId(ferId);
			key.setFollowedId(fedId);
			System.out.println("er "+ferId+" ed "+fedId);
			followService.unFollow(key);
		}
		return "redirect:/home";
	}
	
}
