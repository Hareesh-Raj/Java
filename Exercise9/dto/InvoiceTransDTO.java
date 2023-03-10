package Exercise9.dto;

public class InvoiceTransDTO {
	private int itemNumber,itemQuantity;
	private String invoiceNumber;
	public InvoiceTransDTO()
	{
		
	}
	public InvoiceTransDTO(String invoiceNumber,int itemNumber,int itemQuantity) {
		this.invoiceNumber = invoiceNumber;
		this.itemNumber = itemNumber;
		this.itemQuantity = itemQuantity;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int invoiceNumber) {
		this.itemNumber = invoiceNumber;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	@Override
	public String toString() {
		String str= "InvoiceTransDTO [itemnumber=" + itemNumber + ", invoicenumber=" + invoiceNumber + ", itemquantity=" + itemQuantity + "]";
		return str;
	}
}
