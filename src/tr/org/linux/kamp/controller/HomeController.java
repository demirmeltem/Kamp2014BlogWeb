package tr.org.linux.kamp.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tr.org.linux.kamp.model.Post;
import tr.org.linux.kamp.service.PostService;

@WebServlet("/home")
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		PostService postService = new PostService();
		Collection<Post> allPosts =  postService.getAllPosts();
		req.setAttribute("posts", allPosts);
		
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//FIXME this method should be deleted, use redirect instead.
		
		PostService postService = new PostService();
		Collection<Post> allPosts =  postService.getAllPosts();
		req.setAttribute("posts", allPosts);
		
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}

}
