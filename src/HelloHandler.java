import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


public class HelloHandler extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(resp.SC_OK);
		List<String> userNames = DatabaseUtil.getUserNames();
		System.out.println(userNames);
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().println("hello world"+userNames);
	}
}
