package fci.sw2.project.notification;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fci.sw2.project.post.*;

@Controller
public class NotificationController {
	
	@Autowired
	private NotificationService notifyService;
	@Autowired
	private PostService postS;
	
	@RequestMapping(method = RequestMethod.GET, value = { "/notification" })
	public String showNotifications( Model model) {
		List<Notification> myNotifications = new ArrayList<Notification>();
		
		myNotifications=notifyService.getAllPostsByUserId("init");
		
		model.addAttribute("notify", myNotifications);
		
		
		return "notification";
	}
	@RequestMapping(method = RequestMethod.GET, value = { "/getPost" })
	public String showpost(HttpServletRequest request, Model model) {
		String id=request.getParameter("id");
		Post p=new Post();
		p=postS.getPostById(id);
		model.addAttribute("post", p);

		return "showpost";
	}
	
}
