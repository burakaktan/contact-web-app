package contactWebApp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchContactServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/search-contact.jsp");
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("/search has taken a post");
		String name = (String) req.getParameter("name");
		
		Object[] arr=null;
		try {
			arr = Contact.searchForName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(arr == null || arr.length == 0)
		{
			resp.getWriter().println("Not found");
		}
		else
		{
			req.setAttribute("searchResults", arr);
			//req.getSession().setAttribute("searchResults", arr);
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/search-contact-resulted.jsp");
			disp.forward(req, resp);
		}
	}

}
