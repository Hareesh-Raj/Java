package Exercise2;

import java.util.Scanner;

public class Question9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcAverage1 obj=new CalcAverage1();
		System.out.println(obj.calc());
	}

}

class CalcAverage1{
	int number;
	int avg;
	int count;
	String str;
	Scanner sc=new Scanner(System.in);
	CalcAverage1()
	{
		 avg=0;
		 count=10;
	}
	public int calc()
	{
		System.out.println("Enter the Numbers");
		for(int i=0;i<10;i++)
		{
			try {	
				str=sc.next();
				Input1.check(str);
				number=Integer.parseInt(str);
			}
			catch(InputException e)
			{
				i--;
				e.visit();
			}
			
			avg+=number;
		}
		return avg/count;
	}
}

class Input1{
	public static void check(String str) throws InputException
	{
		int number=0;
		if(str.length()>0)
		{
			int len=str.length();
			for(int i=0;i<len;i++)
			{
				if(i==0 && str.charAt(i)=='-')
				{
					throw new OwnException1("Negative number");
				}
				else if(!Character.isDigit(str.charAt(i)))
				{
					throw new NumberFormatException1("Not a number");
				}
			}
			 number=Integer.parseInt(str);
		}
		if(number>100)
		{
			throw new OwnException1("Greater Than 100");
		}
			
	}
}
abstract class ErrorHandler1{
	abstract public void HandleNumberFormat();
	abstract public void OwnException();
}
 class ErrorHandlerImpl1 extends ErrorHandler1{

	@Override
	public void HandleNumberFormat() {
		// TODO Auto-generated method stub
		System.out.println("The input must be integer...");
		
	}

	@Override
	public void OwnException() {
		// TODO Auto-generated method stub
		System.out.println("Number should be in range 0 to 100");
	}
	
}
class NumberFormatException1 extends InputException{
	String msg;
	public NumberFormatException1(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
	@Override
	public void visit() {
		
		ErrorHandler1 obj=new ErrorHandlerImpl1();
		obj.HandleNumberFormat();
		
	}
	
}
class OwnException1 extends InputException{
	String msg;
	OwnException1(String msg)
	{
		this.msg=msg;
	}
	
	public String toString() {
		return msg;
	}

	@Override
	public void visit() {
		ErrorHandler1 obj=new ErrorHandlerImpl1();
		obj.OwnException();
	}
}

abstract class InputException extends Exception{
	abstract public void visit();
}