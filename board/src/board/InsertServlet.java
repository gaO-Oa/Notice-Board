package board;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	BoardService bs;
	private Board board;

	@Override
	public void init(ServletConfig config) throws ServletException {
		board = (Board) config.getServletContext().getAttribute("board");
		bs = new BoardService(board);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String inputUser = (String) req.getParameter("user");
		String inputTitle = (String) req.getParameter("title");
		String inputContent = req.getParameter("content");
		String highlightCheck = req.getParameter("highlight");
		if (highlightCheck == null) {
			highlightCheck = "off";
		}
		Post post = new Post(inputUser, inputTitle, inputContent, (highlightCheck.equals("on")));
		bs.addPost(post);

		req.getRequestDispatcher("/list").forward(req, resp);
	}

}
