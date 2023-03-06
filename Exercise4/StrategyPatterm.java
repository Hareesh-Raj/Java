package Exercise4;
import java.util.Scanner;

public class StrategyPatterm {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		Human hareesh=new Human();
		while(true) {
			System.out.println("Enter object..");
			String str=sc.next();
			hareesh.obj=(Objects)Class.forName(str).getConstructor().newInstance();
			hareesh.doSomething();
		}
	}

}

class Human{
	Objects obj;
	public void doSomething()
	{
		obj.reactions();
	}
}

abstract class Objects{
	 abstract public void reactions();
}

class Dog extends Objects{
	public Dog()
	{
		
	}
	@Override
	public void reactions() {
		System.out.println("Plays with dog...");
	}
}
class Girl extends Objects{
	public Girl()
	{
		
	}
	@Override
	public void reactions() {
		System.out.println("Happyyyyy...");
	}
	
}
class Boy extends Objects{
	public Boy()
	{
		
	}
	@Override
	public void reactions() {
		System.out.println("Hangout.....");
		
	}
	
}