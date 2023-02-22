package Exercise2;

import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Division obj=new Division();
		obj.calc();
	}

}

class Division{
	Scanner sc=new Scanner(System.in);
	public void calc() 
	{
		String numerator;
		String divisor;
		
		int num;
		int div;
		while(true)
		{
			System.out.println("Enter Numerator and Divisor");
			numerator=sc.next();
			divisor=sc.next();
			if(numerator.toLowerCase().charAt(0)=='q')
				{
				System.out.println("Its End...");
				break;
				}
			else {
				try {
					Input.check(numerator,divisor);
					num=Integer.parseInt(numerator);
					div=Integer.parseInt(divisor);
					System.out.println(num/div);
				}
				catch(DivisionException e)
				{
					e.visit()
;				}
			}
		}
	}
}

abstract class DivisionException extends Exception{
	abstract public void visit();
}

class Input {

	public static void check(String num,String div) throws DivisionException{
		if(num==null || div==null)
		{
			throw new NullNumberError("There Should be a number...");	
		} 
		else if(!Character.isDigit(num.charAt(0)) || !Character.isDigit(div.charAt(0))){
			throw new NonNumberError("The inputs must be a digit");
		}
		else if(div.charAt(0)=='0')
		{
			
			throw new ZeroError("Divison by zero..");
		}
	}
	
}

abstract class ErrorHandler{
	abstract public void zeroDivison();
	abstract public void nonDigit();
	abstract public void nullNumber();
}

class ErrorHandlerImpl extends ErrorHandler{

	@Override
	public void zeroDivison() {
		System.out.println("The Divisor must be a non zero...");
		
	}

	@Override
	public void nonDigit() {
		System.out.println("The Input must be a digit..");
		
	}

	@Override
	public void nullNumber() {
		System.out.println("There Should be a number entered..");
		
	}
	
}

class ZeroError extends DivisionException{
	String msg;
	ZeroError(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
	public void visit()
	{
		ErrorHandler obj=new ErrorHandlerImpl();
		obj.zeroDivison();
	}
}

class NonNumberError extends DivisionException{
	String msg;
	public NonNumberError(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
	@Override
	public void visit() {
		ErrorHandler obj=new ErrorHandlerImpl();
		obj.nonDigit();
		
	}
	
}
class NullNumberError extends DivisionException{
	String msg;
	public NullNumberError(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
	@Override
	public void visit() {
		ErrorHandler obj=new ErrorHandlerImpl();
		obj.nonDigit();
		
	}
	
}