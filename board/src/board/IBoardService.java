package board;

public interface IBoardService {
	
	int addPost(Post post);
	
	void deletePost(int pk);

	Post findPost(int pk);
	
	Post seachPostWithUser(String user);

	Post seachPostWithTitle(String title);
	
}
