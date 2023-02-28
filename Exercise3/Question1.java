package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Hareesh Raj Ramanathan
 * 
 * This Program is to print the odd numbers and even numbers using individual threads.
 *  
  */

public class Question1 {
	/**
	 *  @param args is the argument unused.
	 *  In this main method we create two threads and we call the two static methods to print the numbers.
	 *  we are closing the thread in line 31.
	 * */
	public static void main(String[] args) {
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->
		{
			PrintValues.printEven(0);
		});
		es.execute(()->{
			PrintValues.printOdd(1);
			
		});
		es.shutdown();
	}

}
class PrintValues{
	/**
	 * @param num is the integer argument that is used to print the odd numbers.
	 * The method printOdd will print odd numbers by getting a single argument.
	 * Since we need to print the numbers until 100 we running the for loop up to 100.
	 * we are incrementing the i by 2.
	  */
	synchronized  public static void printOdd(int num)
	{
		for(int i=num;i<100;)
		{
			System.out.print(i+" ");
			i+=2;
		}
		System.out.println("PrintOdd...");
	}
	
	/**
	 * @param num is the integer argument that is used to print the odd numbers.
	 * The method printEven will print even numbers by getting a single argument.
	 * The i variables are incremented by 2.  
	 */
	synchronized public static void printEven(int num)
	{
		for(int i=num;i<100;)
		{
			System.out.print(i+" ");
			i+=2;
		}
		System.out.println("PrintEven...");
	}
	
}
