package Exercise9;

import Exercise9.action.Action;
import Exercise9.action.LoginAction;
import Exercise9.action.LogoutAction;

public class Application {

	public static void main(String[] args) {
		Action action=new LoginAction();
		
		String result=action.execute("somu", "secret");
		
		System.out.println(result);
		
		try {
			Thread.sleep(5000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		LogoutAction action2=new LogoutAction();
		
		result=action2.execute("somu");
		System.out.println();

	}

}
