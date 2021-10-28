package contactWebApp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 2 -- verilen flow ayni name de 2 kisi ayni isimde olayini goz ardi ediyor anladigim kadariyla
// galiba 2 kisi ayni isimde olabilir tarzi bir seyler demistiniz
// bu durumda nasil bir sey yapiyoruz
@WebServlet("/create")
public class CreateContactServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/create-contact.jsp");
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("post u aldim");
		String name = (String)req.getParameter("name");
		String gsm = (String)req.getParameter("gsm");
		
		Contact c = new Contact(name,gsm);
		boolean success = false;
		try
		{
			success = c.addToDatabase();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		if(success)
		{
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/operation-successful.jsp");
			disp.forward(req, resp);
		}
		else
		{
			System.out.println("error :(");
			this.doGet(req,resp);
		}
	}
	@Override
	public void destroy(){
		
		try {
			Contact.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
