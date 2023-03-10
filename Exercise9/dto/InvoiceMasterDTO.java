package Exercise9.dto;

import java.sql.Date;

public class InvoiceMasterDTO{
	
	public InvoiceMasterDTO() {
		
	}
	
	public InvoiceMasterDTO(String invoiceNumber, Date date, String customerID) {
		this.invoiceNumber=invoiceNumber;
		this.date=date;
		this.customerID=customerID;
	}
	
	public String getInvoiceno() {
		return invoiceNumber;
	}

	public void setInvoiceno(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getCustomerid() {
		return customerID;
	}

	public void setCustomerid(String customerid) {
		this.customerID = customerid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@Override
		public String toString() {
			String str= "InvoicemasterDTO [itemnumber=" + invoiceNumber + ", customerid=" + customerID + ", date=" + date + "]";
			return str;
		}
	private String invoiceNumber,customerID;
	private Date date;
}
