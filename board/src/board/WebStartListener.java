package board;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebStartListener implements ServletContextListener {
	private Board board;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		board = new Board();
		sce.getServletContext().setAttribute("board", board);
	}

	public Board getBoard() {
		return board;
	}

}
