package Exercise9.dao;

import java.sql.Date;
import java.util.Collection;

import Exercise9.dto.InvoiceTransDTO;

abstract public class InvoiceTransDAO {
	abstract public InvoiceTransDTO findByID(int itemNumber,String invoiceNumber);
	abstract public Collection<InvoiceTransDTO> findAll();
	abstract public InvoiceTransDTO update(InvoiceTransDTO dto);
	abstract public int deleteItem(InvoiceTransDTO dto);
}
