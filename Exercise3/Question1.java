package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->
		{
			PrintValues.printEven(0);

		});
		es.execute(()->
		{
			PrintValues.printOdd(1);
		});
	}

}
class PrintValues{
	static int number=0;
	synchronized public static void printOdd(int num)
	{
		for(int i=num;i<100;)
		{
			System.out.print(i+" ");
			i+=2;
		}
	}
	synchronized public static void printEven(int num)
	{
		for(int i=num;i<100;)
		{
			System.out.print(i+" ");
			i+=2;
		}
	}
	
}
