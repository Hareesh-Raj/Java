package Exercise2;

import java.io.IOException;

public class Question6 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Derived obj=new Derived();
	}

}
class Base{
	public Base() throws Exception
	{
		System.out.println("hello");
		throw new IOException();
	}
}
class Derived extends Base{
	public Derived() throws Exception
	{
		Base obj=new Base();
//		try {
//			Base obj=new Base();
//		}
//		catch(Exception e)
//		{
//			System.out.println("ih ");
//		}
//		finally {
//			System.out.println("hi");
		}
		
	}
