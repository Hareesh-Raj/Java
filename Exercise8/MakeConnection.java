package Exercise8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("hello");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static ThreadLocal<Connection> tlocal=new ThreadLocal<>();
	public static Connection getConnection()
	{
		Connection con=tlocal.get();
		try 
		{
			if(con==null)
			 {
				con=DriverManager.getConnection("jdbc:mysql://localhost/ace2023","root","hareesh1949");
				tlocal.set(con);
				return con;
			 }
			else
				return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static void closeConnection(Exception e)
	{
		Connection con=tlocal.get();
		if(con!=null)
		{
			try 
			{
			if(e==null)
					con.commit();
			else
				con.rollback();
			}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
			finally {
				try {
					con.close();
				}
				catch(Exception x)
				{
					x.printStackTrace();
				}
			}
			tlocal.remove();
		}
}
}
