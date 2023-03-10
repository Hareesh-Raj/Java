package Exercise9.dto;

public class CustomerDTO {
	public CustomerDTO()
	{
		
	}
	public CustomerDTO(String customerID,String customerName,String customerAddress) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String cid) {
		this.customerID = cid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String cname) {
		this.customerName = cname;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String caddr) {
		this.customerAddress = caddr;
	}
	@Override
	public String toString() {
		String str = "CustomerDTO [customerid=" + customerID + ", customername=" + customerName + ", customeraddress=" + customerAddress + "]";
		return str;
	}
	private String customerID,customerName,customerAddress;
}
