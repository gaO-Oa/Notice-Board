package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/", "/list"})
public class ListServlet extends HttpServlet {
	BoardService bs;
	ArrayList<Post> searchPosts;
	private Board board;

	@Override
	public void init(ServletConfig config) throws ServletException {
		board = (Board) config.getServletContext().getAttribute("board");
		bs = new BoardService(board);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searchContent = req.getParameter("select");
		String inputSearch = req.getParameter("inputSearch");
		Post searchPost = null;
		searchPosts = new ArrayList<>();
		
		if (searchContent != null && inputSearch != null ) {
			if(searchContent.equals("user")) {
				searchPost = bs.seachPostWithUser(inputSearch);
				if (searchPost != null) {
					searchPosts.add(0, searchPost);					
				}
			} else {
				searchPost = bs.seachPostWithTitle(inputSearch);
				if (searchPost != null) {
					searchPosts.add(0, searchPost);					
				}
			}
			req.setAttribute("posts", searchPosts);
			req.getRequestDispatcher("WEB-INF/inputForm.jsp").forward(req, resp);
		} else {
			req.setAttribute("posts", board.getPosts());
			req.getRequestDispatcher("WEB-INF/inputForm.jsp").forward(req, resp);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("posts", board.getPosts());
		req.getRequestDispatcher("WEB-INF/inputForm.jsp").forward(req, resp);
	}

}
