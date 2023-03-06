package Exercise9.service;

import Exercise9.component.UserComponent;
import Exercise9.component.UserComponentImpl;

public class LogoutServiceImpl implements LogoutService{
	private static LogoutServiceImpl userser;
	public static LogoutServiceImpl getLoginServiceImplObject() {
		if(userser==null) {
			userser=new LogoutServiceImpl();
			return userser;
		}
		else {
			return userser.createClone();
		}
	}
	private LogoutServiceImpl createClone() {
		if(userser!=null) {
			try{
				return (LogoutServiceImpl)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	private LogoutServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String logout(String uname) {
		UserComponent usercom=UserComponentImpl.getUserComponentImplObject();
		
		int n=usercom.updateFlag(uname, 0);
		return "logoutsuccess";
	}
}