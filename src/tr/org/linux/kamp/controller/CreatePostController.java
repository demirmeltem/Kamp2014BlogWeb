package tr.org.linux.kamp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tr.org.linux.kamp.model.PhotoPost;
import tr.org.linux.kamp.model.Post;
import tr.org.linux.kamp.model.TextPost;
import tr.org.linux.kamp.model.VideoPost;
import tr.org.linux.kamp.service.PostService;

@WebServlet("/createPost")
public class CreatePostController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String type = req.getParameter("type");

		switch (type) {
		case "text":
			req.getRequestDispatcher("/WEB-INF/jsp/createTextPost.jsp")
					.forward(req, resp);
			break;
		case "photo":
			req.getRequestDispatcher("/WEB-INF/jsp/createPhotoPost.jsp")
					.forward(req, resp);
			break;
		case "video":
			req.getRequestDispatcher("/WEB-INF/jsp/createVideoPost.jsp")
					.forward(req, resp);
			break;

		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PostService postService = new PostService();

		String type = req.getParameter("type");

		String title = req.getParameter("title");
		String content = req.getParameter("content");

		Post post = null;

		switch (type) {
		case "text":
			post = new TextPost(title, content);
			break;
		case "photo":
			String photoUrl = req.getParameter("photoUrl");
			post = new PhotoPost(title, content, photoUrl);
			break;
		case "video":
			String videoUrl = req.getParameter("videoUrl");
			post = new VideoPost(title, content, videoUrl);
			break;
		}

		postService.save(post);

		req.setAttribute("message", "Post created.");

		req.getRequestDispatcher("/home").forward(req, resp);

	}

}
