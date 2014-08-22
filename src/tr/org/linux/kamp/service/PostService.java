package tr.org.linux.kamp.service;

import java.util.Collection;

import tr.org.linux.kamp.dao.PostDao;
import tr.org.linux.kamp.model.Post;

public class PostService {

	private PostDao postDao;

	public boolean save(Post post) {
		getDao().save(post);

		return true;
	}

	public Collection<Post> getAllPosts() {
		return getDao().getAllPosts();
	}

	private PostDao getDao() {
		if (postDao == null) {
			postDao = new PostDao();
		}

		return postDao;
	}

	public Post getById(String id) {
		return getDao().getById(id);
	}
}
