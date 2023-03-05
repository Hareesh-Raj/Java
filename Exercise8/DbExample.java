package Exercise8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DbExample {

	public static void main(String[] args) {
		Bank person1=new Bank();
		person1.transfer("a001","a003", 1000);
	}

}
class Bank{
	public void transfer(String crid,String dbid,int amt)
	{
		Connection con=MakeConnection.getConnection();
		try {
			con.setAutoCommit(false);
			debit(dbid,amt,con);
			credit(crid,amt,con);
			MakeConnection.closeConnection(null);
		} catch (Exception e) {
			
			e.printStackTrace();
			MakeConnection.closeConnection(e);
			
		}
		
	}
	public void debit(String aid,int amount,Connection con) throws Exception
	{
		PreparedStatement ps=con.prepareStatement("select amount from accountdetails where aid=?");
		ps.setString(1, aid);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			int amt=rs.getInt("amount");
			if(amt<amount)
				throw new InSufficientBalanceException("Insufficient Balance..");
			else 
			{
				amt-=amount;
				ps=con.prepareStatement("update accountdetails set amount=? where aid=?");
				ps.setInt(1, amt);
				ps.setString(2, aid);
				ps.executeUpdate();
			}
		}
		else
			throw new InValidUserException("Invalid User..");
	}
	public void credit(String aid,int amount,Connection con) throws Exception
	{
		PreparedStatement ps=con.prepareStatement("select amount from accountdetails where aid=?");
		ps.setString(1, aid);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			ps=con.prepareStatement("update accountdetails set amount=? where aid=?");
			int amt=rs.getInt("amount");
			amt+=amount;
			ps.setInt(1, amt);
			ps.setString(2, aid);
			ps.executeUpdate();
			
		}
		else
			throw new InValidUserException("Invalid user....");
	}
}

class InSufficientBalanceException extends Exception{
	String msg;
	public InSufficientBalanceException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		
		return msg;
	}
}
class InValidUserException extends Exception{
	String msg;
	public InValidUserException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		
		return msg;
	}
}