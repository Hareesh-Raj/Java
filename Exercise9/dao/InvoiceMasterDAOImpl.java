package Exercise9.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Exercise9.DBUtility;
import Exercise9.dto.InvoiceMasterDTO;

public class InvoiceMasterDAOImpl extends InvoiceMasterDAO implements Cloneable{
	
	private InvoiceMasterDAOImpl()
	{
		
	}
	
	private static InvoiceMasterDAOImpl invoicemasterdao;
	public static InvoiceMasterDAOImpl getUserDAOImplObject() {
		if(invoicemasterdao==null) {
			invoicemasterdao=new InvoiceMasterDAOImpl();
			return invoicemasterdao;
		}
		else {
			return invoicemasterdao.createClone();
		}
	}
	private InvoiceMasterDAOImpl createClone() {
		if(invoicemasterdao!=null) {
			try{
				return (InvoiceMasterDAOImpl)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public InvoiceMasterDTO findByID(String invoiceno) {
		try {
		Connection con=DBUtility.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from invoicemaster where invoiceno=?");
		ps.setString(1, invoiceno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			InvoiceMasterDTO dto=new InvoiceMasterDTO();
			dto.setInvoiceno(rs.getString("invoiceno"));
			dto.setDate(rs.getDate("date"));
			dto.setCustomerid(rs.getString("customerid"));
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
	public Collection<InvoiceMasterDTO> findAll(){
		try {
			Connection con=DBUtility.getConnection();
			Statement ps=con.createStatement();
			
			ResultSet rs=ps.executeQuery("select * from invoicemaster");
			List<InvoiceMasterDTO> invoices=new ArrayList<InvoiceMasterDTO>();
			while(rs.next()) {
				InvoiceMasterDTO dto=new InvoiceMasterDTO();
				dto.setInvoiceno(rs.getString("invoiceno"));
				dto.setDate(rs.getDate("date"));
				dto.setCustomerid(rs.getString("customerid"));
				invoices.add(dto);
			}
			return invoices;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}
	public int update(InvoiceMasterDTO dto) {
		try {
			Connection con=DBUtility.getConnection();
			String ino=dto.getInvoiceno();
			PreparedStatement ps=con.prepareStatement("select * from invoicemaster where invoiceno=?");
			ps.setString(1, ino);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ps=con.prepareStatement("update invoicemaster set customerid=?,date=? where invoiceno=?");
				ps.setString(1, dto.getCustomerid());
				ps.setDate(2, dto.getDate());
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
	public int deleteItem(InvoiceMasterDTO dto) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from invoicemaster where invoiceno=?");
			ps.setString(1, dto.getInvoiceno());
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
	public InvoiceMasterDTO findByOrderDate(Date date) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from invoicemaster where date=?");
			ps.setDate(1, date);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				InvoiceMasterDTO dto=new InvoiceMasterDTO();
				dto.setInvoiceno(rs.getString("invoiceno"));
				dto.setDate(rs.getDate("date"));
				dto.setCustomerid(rs.getString("customerid"));
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
}
