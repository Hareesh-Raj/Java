package Exercise9.action;

import Exercise9.service.LogoutService;
import Exercise9.service.LogoutServiceImpl;

public class LogoutAction {
	public String execute(String uname) {
		LogoutService ls=LogoutServiceImpl.getLoginServiceImplObject();
		String result=ls.logout(uname);
		return result;
	}
}
