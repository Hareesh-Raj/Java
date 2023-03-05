package Exercise8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation {

	public static void main(String[] args) {
		ResultSet rs;
		Statement st;
		Connection con=MakeConnection.getConnection();
		try {
			st=con.createStatement();
			st.execute("create table accountdetails(aid varchar(30),uname varchar(30),amount int)");
			rs=st.executeQuery("desc accountdetails");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
