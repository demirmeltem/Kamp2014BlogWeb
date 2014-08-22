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

@WebServlet("/showPage")
public class ShowPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String id = req.getParameter("id");
		PostService postService = new PostService();
		Post post = postService.getById(id);

		req.setAttribute("post", post);

		String type = "textPost";

		if (post instanceof PhotoPost) {
			type = "photoPost";
		} else if (post instanceof VideoPost) {
			type = "videoPost";
		}

		req.setAttribute("type", type);

		req.getRequestDispatcher("/WEB-INF/jsp/showPage.jsp")
				.forward(req, resp);

	}
}
