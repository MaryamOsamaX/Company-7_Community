package fci.sw2.project.comment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class CommentController {
	@Autowired
	private CommentService commentService;

	@RequestMapping(method = RequestMethod.GET, value = { "/showComments" })
	public String showComments(HttpServletRequest request, Model model) {
		List<Comment> myComments = new ArrayList<Comment>();
		Comment c = new Comment();
		String postId = request.getParameter("id");
		//System.out.println("2");
		myComments = commentService.getAllCommentsForPost(postId);
		model.addAttribute("mycomments", myComments);
		model.addAttribute("commentdata", c);
		model.addAttribute("savePostId", postId);
		//System.out.println("# "+postId);
		return "showComments";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showComments") 
	public String makeComment(HttpServletRequest request,Model model, @ModelAttribute("commentdata") Comment commentData) {
	//	List<Comment> myComments = new ArrayList<Comment>();
		if (commentData != null) {
			     String postId = request.getParameter("id");
			     
				commentData.setUserId("init");/************** HERE ****************/
				commentData.setPostId(postId);
				commentService.initialId(commentData);

				commentService.makeComment(commentData);
				
			
		} 
		  
	  return "showComments";
		
	}

}
