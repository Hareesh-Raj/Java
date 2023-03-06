package Exercise9.dto;

public class InvoiceTransDTO {
	private int itemno,itemqty;
	private String invoiceno;
	public InvoiceTransDTO()
	{
		
	}
	public InvoiceTransDTO(String invoiceno,int itemno,int itemqty) {
		this.invoiceno=invoiceno;
		this.itemno=itemno;
		this.itemqty=itemqty;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public int getItemqty() {
		return itemqty;
	}
	public void setItemqty(int itemqty) {
		this.itemqty = itemqty;
	}
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	@Override
	public String toString() {
		String str= "InvoiceTransDTO [itemnumber=" + itemno + ", invoicenumber=" + invoiceno + ", itemquantity=" + itemqty + "]";
		return str;
	}
}
