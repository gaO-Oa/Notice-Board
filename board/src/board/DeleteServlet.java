package board;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	BoardService bs;
	private Board board;

	@Override
	public void init(ServletConfig config) throws ServletException {
		board = (Board) config.getServletContext().getAttribute("board");
		bs = new BoardService(board);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deletePk = req.getParameter("deletePk");
		int deleteNum = Integer.parseInt(deletePk);
		bs.deletePost(deleteNum);
		System.out.println("삭제완료");
		System.out.println(board.getPosts());
		req.getRequestDispatcher("/list").forward(req, resp);
	}
	
}
