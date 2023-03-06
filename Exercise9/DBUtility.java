package Exercise9;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtility {
	public DBUtility() {
		
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<Connection>();
	
	public static Connection getConnection() {
		Connection con=tlocal.get();
		if(con==null) {
			try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/ace2023","root","hareesh1949");
			con.setAutoCommit(false);
			tlocal.set(con);
			return con;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return con;
		}
	}
	
	public static void closeConnection(Exception e) {
		Connection con=tlocal.get();
		if(con!=null) {
			try {
			if(e==null) {
				con.commit();
			}
			else {
				con.rollback();
			}
			}catch(Exception ee) {
				ee.printStackTrace();
			}
			finally {
				try{con.close();}catch(Exception x) {x.printStackTrace();}
				tlocal.remove();				
			}
		}
	}
}