package Exercise4;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class VisitorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hareesh obj=new Hareesh();
		obj.reactions();
	}

}

class Hareesh{
	String str;
	Scanner sc=new Scanner(System.in);
	public void reactions()
	{
		str=sc.next();
		try {
			Input.check(str);
		}
		catch(InputException e)
		{
			e.visit();
		}
		finally {
			sc.close();
		}
	}
}
class Input{
	static Bad obj;
	public static void check(String str) throws InputException
	{
		try {
			str="Exercise4."+str;
			obj=(Bad)Class.forName(str).getConstructor().newInstance();
			obj.reply();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | NoClassDefFoundError e) {
			// TODO Auto-generated catch block
			System.out.println("No Problem...");
		}
		
			
		
	}
}

abstract class Bad{
	abstract public void reply() throws InputException;
}

class BadDog extends Bad{
	public BadDog() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void reply() throws InputException{
		throw new BadDogException("BadDog Exception..");
	}
	
}
class BadGirl extends Bad{
	public BadGirl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void reply() throws InputException{
		throw new BadGirlException("BadGirl Exception..");
	}
	
}

abstract class InputException extends Exception{
	
	abstract public void visit();
}

abstract class ErrorHandler{
	abstract public void handleBadDog();
	abstract public void handleBadGirl();
}

class ErrorHandlerImpl extends ErrorHandler{

	@Override
	public void handleBadDog() {
		System.out.println("Dont look into their eyes and dont run...");
		
	}

	@Override
	public void handleBadGirl() {
		System.out.println("Stay Away....Run..");
		
	}
	
}

class BadDogException extends InputException{
	String msg;
	public BadDogException(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String toString() {
		
		return msg;
	}
	@Override
	public void visit() {
		ErrorHandler obj=new ErrorHandlerImpl();
		obj.handleBadDog();
	}
	
}

class BadGirlException extends InputException{
	String msg;
	public BadGirlException(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String toString() {
		
		return msg;
	}
	@Override
	public void visit() {
		ErrorHandler obj=new ErrorHandlerImpl();
		obj.handleBadGirl();
	}
	
}