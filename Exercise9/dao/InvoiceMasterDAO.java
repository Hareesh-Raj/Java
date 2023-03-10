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

 abstract public class InvoiceMasterDAO {
	abstract public InvoiceMasterDTO findByID(String invoiceNumber);
	abstract public Collection<InvoiceMasterDTO> findAll();
	abstract public InvoiceMasterDTO update(InvoiceMasterDTO invoiceMasterDTO);
	abstract public int deleteItem(InvoiceMasterDTO dto);
	abstract public InvoiceMasterDTO findByOrderDate(Date date);
}
