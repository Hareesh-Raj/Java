package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es=Executors.newFixedThreadPool(2);
		PrintNumber pn=new PrintNumber();
		es.execute(()->{
			for(int i=0;i<100;i++)
			{
				pn.number();
			}
		});
		es.execute(()->{
			for(int i=0;i<10;i++)
			{
				pn.status();
			}
		});
	}

}
class PrintNumber{
	static int number=0;
	synchronized public  void number()
	{
		if(number%10==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println(number);
			number
			notify();
		}
		
	}
	synchronized public  void status()
	{
		System.out.println("The Count reached.."+number);
	}
}

abstract class Writer {
	abstract void write(Writer obj);
}
class Pen extends Writer{

	@Override
	void write(Writer obj) {
		System.out.println("pen");
		
	}
	
}
class Pencil extends Writer{

	@Override
	void write(Writer obj) {
		System.out.println("pencil");
		
	}
}

class Base1{
	public void display() {
		System.out.println("Base1");
	}
}
class Base2{
	public void display()
	{
		System.out.println("Base2");
	}
}

class Derived extends Base
