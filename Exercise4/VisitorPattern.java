package Exercise4;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class VisitorPattern {

	public static void main(String[] args) {
		
		Hareesh obj=new Hareesh();
		obj.reactions();
	}

}

class Hareesh{
	Scanner sc=new Scanner(System.in);
	String str;
	public void reactions()
	{
		str=sc.next();
		try {
			if(str.equals("BadDog")) {
				new BadDog().reply();
			}
			else if(str.equals("BadGirl"))
			{
				new BadGirl().reply();
			}
		} catch (InputException e) {
			e.visit();
		}
	}
}


abstract class Bad{
	abstract public void reply() throws InputException;
}

class BadDog extends Bad{
	public BadDog() {
		
	}
	@Override
	public void reply() throws InputException{
		throw new BadDogException("BadDog Exception..");
	}	
}
class BadGirl extends Bad{
	public BadGirl() {
		
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