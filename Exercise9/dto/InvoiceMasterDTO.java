package Exercise9.dto;

import java.sql.Date;

public class InvoiceMasterDTO{
public InvoiceMasterDTO() {
		
	}
	
	public InvoiceMasterDTO(String invoiceno, Date date, String customerid) {
		this.invoiceno=invoiceno;
		this.date=date;
		this.customerid=customerid;
	}
	
	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@Override
		public String toString() {
			String str= "InvoicemasterDTO [itemnumber=" + invoiceno + ", customerid=" + customerid + ", date=" + date + "]";
			return str;
		}
	private String invoiceno,customerid;
	private Date date;
}
