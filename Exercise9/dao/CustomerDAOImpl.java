package Exercise9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Exercise9.DBUtility;
import Exercise9.dto.CustomerDTO;


public class CustomerDAOImpl extends CustomerDAO implements Cloneable{
	
	
	private CustomerDAOImpl()
	{
		
	}
	
	private static CustomerDAOImpl customerdao;
	public static CustomerDAOImpl getUserDAOImplObject() {
		if(customerdao==null) {
			customerdao=new CustomerDAOImpl();
			return customerdao;
		}
		else {
			return customerdao.createClone();
		}
	}
	private CustomerDAOImpl createClone() {
		if(customerdao!=null) {
			try{
				return (CustomerDAOImpl)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	@Override
	public CustomerDTO findByID(String cid) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customermaster where customerid=?");
			ps.setString(1, cid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CustomerDTO dto=new CustomerDTO();
				dto.setCid(rs.getString("customerid"));
				dto.setCaddr(rs.getString("customeraddress"));
				dto.setCname(rs.getString("customername"));
				return dto;
			}
			else {
				return null;
			}
			}catch(Exception e) {
				DBUtility.closeConnection(e);
				return null;
			}
		
	}

	@Override
	public CustomerDTO findByName(String uname) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customermaster where customername=?");
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CustomerDTO dto=new CustomerDTO();
				dto.setCaddr(rs.getString("customeraddress"));
				dto.setCid(rs.getString("customerid"));
				dto.setCname(rs.getString("customername"));
				return dto;
			}
			else {
				return null;
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		try {
			Connection con=DBUtility.getConnection();
			Statement ps=con.createStatement();
			
			ResultSet rs=ps.executeQuery("select * from customermaster");
			List<CustomerDTO> customers=new ArrayList<CustomerDTO>();
			while(rs.next()) {
				CustomerDTO dto=new CustomerDTO();
				dto.setCaddr(rs.getString("customeraddress"));
				dto.setCid(rs.getString("customerid"));
				dto.setCname(rs.getString("customername"));
				customers.add(dto);
			}
			return customers;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateUser(CustomerDTO userdto) {
		try {
			Connection con=DBUtility.getConnection();
			String cid=userdto.getCid();
			PreparedStatement ps=con.prepareStatement("select * from customermaster where customerid=?");
			ps.setString(1, cid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ps=con.prepareStatement("update customermaster set customername=?,customeraddress=? where customerid=?");
				ps.setString(1, userdto.getCname());
				ps.setString(2, userdto.getCaddr());
				ps.setString(3, userdto.getCid());
				
				int n=ps.executeUpdate();
				DBUtility.closeConnection(null);
				return n;
			}
			else {
				return 0;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteUserByID(String cid) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from customermaster where customerid=?");
			ps.setString(1, cid);
			int n=ps.executeUpdate();
			return n;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}

}
