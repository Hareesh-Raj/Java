package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Hareesh Raj Ramanathan
 * 
 * This Program is to print the number" .
 *  
  */
public class Question7 {

	public static void main(String[] args) {
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		PrintNumber pn=new PrintNumber();
		es.execute(()->{
			for(int i=0;i<100;i++)
			{
				pn.number();
			}
			
		});
		es.shutdown();
	}
}
class PrintNumber{
	
	static int number=1;
	/**
	 * This Program is to print the number" .
	 *  
	  */
	synchronized public  void number()
	{
		if(number%10==0)
		{
			print();
		}
		else
		{
			System.out.println(number);
		}
		number++;
			
		}
		
	synchronized public  void print()
	{
			System.out.println("The Count reached.."+number);			
	}
}