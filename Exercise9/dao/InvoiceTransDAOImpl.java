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
	private static InvoiceTransDAOImpl invoiceTransDAO;
	public static InvoiceTransDAOImpl getUserDAOImplObject() {
		if(invoiceTransDAO == null) {
			invoiceTransDAO = new InvoiceTransDAOImpl();
			return invoiceTransDAO;
		}
		else {
			return invoiceTransDAO.createClone();
		}
	}
	private  InvoiceTransDAOImpl createClone() {
		if(invoiceTransDAO!=null) {
			try {
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
	public InvoiceTransDTO findByID(int itemNumber, String invoiceNumber) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from invoicetrans where invoiceno=? and itemno=?");
			preparedStatement.setString(1, invoiceNumber);
			preparedStatement.setInt(2, itemNumber);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				InvoiceTransDTO invoiceTransDTO = new InvoiceTransDTO();
				invoiceTransDTO.setInvoiceNumber(rs.getString("invoiceno"));
				invoiceTransDTO.setItemNumber(rs.getInt("itemno"));
				invoiceTransDTO.setItemQuantity(rs.getInt("itemqty"));
				return invoiceTransDTO;
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
			Connection connection = DBUtility.getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from invoicetrans");
			List<InvoiceTransDTO> transactions = new ArrayList<InvoiceTransDTO>();
			while(resultSet.next()) {
				InvoiceTransDTO dto = new InvoiceTransDTO();
				dto.setInvoiceNumber(resultSet.getString("invoiceno"));
				dto.setItemNumber(resultSet.getInt("itemno"));
				dto.setItemQuantity(resultSet.getInt("itemqty"));
				transactions.add(dto);
			}
			return transactions;
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public InvoiceTransDTO update(InvoiceTransDTO invoiceTransDTO) {
		try {
			Connection connection=DBUtility.getConnection();
			String invoiceno = invoiceTransDTO.getInvoiceNumber();
			int itemno = invoiceTransDTO.getItemNumber();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from invoicetrans where invoiceno=? and itemno=?");
			preparedStatement.setString(1, invoiceno);
			preparedStatement.setInt(2, itemno);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				preparedStatement = connection.prepareStatement("update invoicetrans set itemqty=? where invoiceno=? and itemno=?");
				preparedStatement.setInt(1, invoiceTransDTO.getItemQuantity());
				preparedStatement.setString(2, invoiceno);
				preparedStatement.setInt(3, itemno);
				preparedStatement.executeUpdate();
				DBUtility.closeConnection(null);
				return invoiceTransDTO;
			}
			else {
				return null;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int deleteItem(InvoiceTransDTO dto) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from invoicetrans where invoiceno=? and itemno=?");
			preparedStatement.setString(1, dto.getInvoiceNumber());
			preparedStatement.setInt(2,dto.getItemNumber());
			int n = preparedStatement.executeUpdate();
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
