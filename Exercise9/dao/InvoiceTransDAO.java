package Exercise9.dao;

import java.sql.Date;
import java.util.Collection;

import Exercise9.dto.InvoiceTransDTO;

abstract public class InvoiceTransDAO {
	abstract public InvoiceTransDTO findByID(int itemno,String invoiceno);
	abstract public Collection<InvoiceTransDTO> findAll();
	abstract public int update(InvoiceTransDTO dto);
	abstract public int deleteItem(InvoiceTransDTO dto);
}
