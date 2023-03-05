package Exercise9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Exercise9.DBUtility;
import Exercise9.dto.InvoiceTransDTO;

public class InvoiceTransDAOImpl extends InvoiceTransDAO implements Cloneable{
	private static InvoiceTransDAOImpl invoicetransdao;
	public static InvoiceTransDAOImpl getUserDAOImplObject() {
		if(invoicetransdao==null) {
			invoicetransdao=new InvoiceTransDAOImpl();
			return invoicetransdao;
		}
		else {
			return invoicetransdao.createClone();
		}
	}
	private  InvoiceTransDAOImpl createClone() {
		if(invoicetransdao!=null) {
			try{
				return ( InvoiceTransDAOImpl)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	private InvoiceTransDAOImpl()
	{
		
	}
	@Override
	public InvoiceTransDTO findByID(int itemno, String invoiceno) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from invoicetrans where invoiceno=? and itemno=?");
			ps.setString(1, invoiceno);
			ps.setInt(2, itemno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				InvoiceTransDTO dto=new InvoiceTransDTO();
				dto.setInvoiceno(rs.getString("invoiceno"));
				dto.setItemno(rs.getInt("itemno"));
				dto.setItemqty(rs.getInt("itemqty"));
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
	public Collection<InvoiceTransDTO> findAll() {
		try {
			Connection con=DBUtility.getConnection();
			Statement ps=con.createStatement();
			
			ResultSet rs=ps.executeQuery("select * from invoicetrans");
			List<InvoiceTransDTO> transactions=new ArrayList<InvoiceTransDTO>();
			while(rs.next()) {
				InvoiceTransDTO dto=new InvoiceTransDTO();
				dto.setInvoiceno(rs.getString("invoiceno"));
				dto.setItemno(rs.getInt("itemno"));
				dto.setItemqty(rs.getInt("itemqty"));
				transactions.add(dto);
			}
			return transactions;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int update(InvoiceTransDTO dto) {
		try {
			Connection con=DBUtility.getConnection();
			String invoiceno=dto.getInvoiceno();
			int itemno=dto.getItemno();
			PreparedStatement ps=con.prepareStatement("select * from invoicetrans where invoiceno=? and itemno=?");
			ps.setString(1, invoiceno);
			ps.setInt(2, itemno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ps=con.prepareStatement("update invoicetrans set itemqty=? where invoiceno=? and itemno=?");
				ps.setInt(1, dto.getItemqty());
				ps.setString(2, invoiceno);
				ps.setInt(3, itemno);
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
	public int deleteItem(InvoiceTransDTO dto) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from invoicetrans where invoiceno=? and itemno=?");
			ps.setString(1, dto.getInvoiceno());
			ps.setInt(2,dto.getItemno());
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
