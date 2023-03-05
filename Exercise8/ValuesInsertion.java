package Exercise8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ValuesInsertion {
	public static void main(String[] args) {
		Statement st;
		ResultSet rs;
		Connection con=MakeConnection.getConnection();
		try {			
			 st=con.createStatement();
			 //Insertion 
			int result1=st.executeUpdate("insert into accountdetails values ('a001','Hari',1000)");
			int result2=st.executeUpdate("insert into accountdetails values ('a002','Hareesh',2000)");
			int result3=st.executeUpdate("insert into accountdetails values ('a003','Raj',500)");
			System.out.println(result1+" "+result2+" "+result3);
			
			 //Display
			rs=st.executeQuery("select * from accountdetails");
			while(rs.next())
			{
				System.out.print(rs.getString(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.println(rs.getString(3));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
