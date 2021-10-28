package contactWebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Contact {
	
	private String name,gsm;
	private int id;
	
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return this.name;
	}
	public String getGsm()
	{
		return this.gsm;
	}
	private static Connection conn = null;
	public static void closeConnection() throws SQLException
	{
		conn.close();
	}
	private static String tableName = "contacts";
	
	static
	{
		String jdbcUrl = "jdbc:mysql://localhost:3306/db_jss?useSSL=false";
		String user = "dbuser";
		String password ="kullanicisifree";
		try
		{
			System.out.println("time to connect:");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection is done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void connectToSql()
	{
		String jdbcUrl = "jdbc:mysql://localhost:3306/db_jss?useSSL=false";
		String user = "dbuser";
		String password ="kullanicisifree";
		try
		{
			System.out.println("time to connect:");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection is done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Contact(String name, String gsm)
	{
		this.name = name;
		this.gsm = gsm;
	}
	public Contact(String name, String gsm,int id)
	{
		this.name = name;
		this.gsm = gsm;
		this.id = id;
	}

	public boolean addToDatabase() throws SQLException
	{
		if(conn== null)
			connectToSql();
		
		PreparedStatement pr = conn.prepareStatement("insert into " + tableName + " (name,tel_number) values( ? , ?)");
		pr.setString(1, name);
		pr.setString(2,gsm);
		int affectedRows = pr.executeUpdate();
		if(affectedRows == 0)
			return false;
		return true;
	}
	
	// html anchor tag i
	public static Object[] searchForName(String name) throws SQLException {
		PreparedStatement selector = conn.prepareStatement("select * from " + tableName + " where name like ?");
		selector.setString(1,"%" + name + "%");
		ResultSet rs = selector.executeQuery();
		
		ArrayList<Contact> result = new ArrayList<Contact>();
	
		
		while(rs.next())
		{
			result.add(new Contact(rs.getString("name"),rs.getString("tel_Number"),rs.getInt("id")));
		}
		return result.toArray();
	}
	public static void update(int id, String name, String gsm) throws SQLException
	{
		if(conn== null)
			connectToSql();
		
		System.out.println("gsm is: " + gsm);
		PreparedStatement pr = conn.prepareStatement("update " + tableName + " set name = ? , tel_number = ? where id = ?;");
		pr.setString(1, name);
		pr.setString(2, gsm);
		pr.setInt(3,id);
		
		pr.executeUpdate();
	}

}
