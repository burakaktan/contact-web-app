package contactWebApp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class editContactServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("idToChange = " + req.getParameter("id"));
		req.setAttribute("idToChange",req.getParameter("id"));
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/edit-contact.jsp");
		disp.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id = Integer.parseInt(req.getParameter("idToChange"));
		String name = req.getParameter("new_name");
		String gsm = req.getParameter("new_gsm");
		System.out.println("just before try");
		try {
			Contact.update(id,name,gsm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/operation-successful.jsp");
		disp.forward(req, resp);
	}

}
