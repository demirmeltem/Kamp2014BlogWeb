package tr.org.linux.kamp.dao;

import java.util.Collection;

import tr.org.linux.kamp.FakeDb;
import tr.org.linux.kamp.model.Post;

public class PostDao {

	public boolean save(Post post) {

		if (post.getId() == null || post.getId().trim().length() == 0) {
			String id = String.valueOf(System.currentTimeMillis());
			post.setId(id);
		}
		
		FakeDb.save(post);
		return true;
	}

	public Collection<Post> getAllPosts() {
		return FakeDb.getAllPosts();
	}

	public Post getById(String id) {
		return FakeDb.getById(id);
	}
}
