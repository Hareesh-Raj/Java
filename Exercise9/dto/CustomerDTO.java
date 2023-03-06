package Exercise9.dto;

public class CustomerDTO {
	public CustomerDTO()
	{
		
	}
	public CustomerDTO(String cid,String cname,String caddr) {
		this.cid=cid;
		this.cname=cname;
		this.caddr=caddr;
	}
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddr() {
		return caddr;
	}
	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}
	@Override
	public String toString() {
		String str= "CustomerDTO [customerid=" + cid + ", customername=" + cname + ", customeraddress=" + caddr + "]";
		return str;
	}
	private String cid,cname,caddr;
}
