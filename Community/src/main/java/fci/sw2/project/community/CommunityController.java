package fci.sw2.project.community;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fci.sw2.project.post.Post;
import fci.sw2.project.post.PostService;


@Controller
public class CommunityController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/makePost")
	public String makePostView(Model model)

	{
		Post postData = new Post();
		model.addAttribute("postdata", postData);

		return "makePost";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/makePost")
	public void makePost(Model model, @ModelAttribute("postdata") Post postData)
	{
		postData.setUserId("init");
		postService.initialId(postData);
		postData.setNumOfVotesUp(0);
		postData.setNumOfVotesDown(0);
		postService.makePost(postData);
		model.addAttribute("message", "Posted Successfully!");
		
	}
}
