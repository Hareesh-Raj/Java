package Exercise9.action;

import Exercise9.service.LoginService;
import Exercise9.service.LoginServiceImpl;

public class LoginAction extends Action{

	@Override
	public String execute(String uname, String upass) {
		
			LoginService ls=LoginServiceImpl.getLoginServiceImplObject();
			String result=ls.login(uname, upass);
			return result;
	}

}
