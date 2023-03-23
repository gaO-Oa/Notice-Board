package board;

import java.util.ArrayList;

public class Board {
	
	private int pk = 0;
	public ArrayList<Post> posts;
	
	public Board() {
		posts = new ArrayList<Post>();
	}
	public void addPost(Post post) {
		pk++;
		post.setPk(pk);
		posts.add(post);
	}
	public void deletePost(int pk) {
		Post post = findPost(pk);
		if (post != null) {			
			posts.remove(post);
		}
	}
	public Post findPost(int pk) {
		for(Post post : posts) {
			if (pk == post.getPk()) {
				return post;
			}
		} 
		return null;
	}
	public Post seachPostWithUser(String user) {
		for(Post post : posts) {
			if (user.equals(post.getUser())) {
				return post;
			}
		}
		return null; 
	}
	public Post seachPostWithTitle(String title) {
		for(Post post : posts) {
			if (title.equals(post.getTitle())) {
				return post;
			}
		}
		return null; 
	}
	
	public ArrayList<Post> getPosts() {
		return posts;
	}
	
	
}
