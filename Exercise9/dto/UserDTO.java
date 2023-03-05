package Exercise9.dto;
import java.io.Serializable;
import java.util.Objects;
public class UserDTO implements Comparable<UserDTO>,Serializable{
	
	public UserDTO() {
		
	}
	
	public UserDTO(int uid, int age, int flag, String uname, String upass) {
		this.uid = uid;
		this.age = age;
		this.flag = flag;
		this.uname = uname;
		this.upass = upass;
	}
	@Override
	public int compareTo(UserDTO o) {
		// TODO Auto-generated method stub
		return this.uname.compareTo(o.uname);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, flag, uid, uname, upass);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return age == other.age && flag == other.flag && uid == other.uid && Objects.equals(uname, other.uname)
				&& Objects.equals(upass, other.upass);
	}
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", age=" + age + ", flag=" + flag + ", uname=" + uname + ", upass=" + upass
				+ "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	private int uid,age,flag;
	private String uname,upass;
	
}