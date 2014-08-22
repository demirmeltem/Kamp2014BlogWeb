package tr.org.linux.kamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tr.org.linux.kamp.model.Post;
import tr.org.linux.kamp.model.User;


public class FakeDb {

	private static Map<String, Post> postStorage;
	private static Map<String, User> userStorage;
	
	static{
		postStorage = new HashMap<String, Post>();
		userStorage = new HashMap<String, User>();
	}
	
	public static boolean save(Post post){
		postStorage.put(post.getId(), post);
		return true;
	}
	
	public static Collection<Post> getAllPosts(){
		return postStorage.values();
	}

	public static Post getById(String id) {
		return postStorage.get(id);
	}
}
