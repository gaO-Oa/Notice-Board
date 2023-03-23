package board;

public class BoardService implements IBoardService {
	public Board board;

	public BoardService(Board board) {
		this.board = board;
	}
	
	
	@Override
	public int addPost(Post post) {

		String user = post.getUser();
		String title = post.getTitle();
		String content = post.getContent();

		if (user != null && title != null && content != null) {
			board.addPost(post);
			return 1;
		}
		return -1;
	}

	@Override
	public Post findPost(int pk) {
		return board.findPost(pk);
	}


	@Override
	public void deletePost(int index) {
		board.deletePost(index);
	}


	@Override
	public Post seachPostWithUser(String user) {
		return board.seachPostWithUser(user);
	}


	@Override
	public Post seachPostWithTitle(String title) {
		return board.seachPostWithTitle(title);
	}
}
