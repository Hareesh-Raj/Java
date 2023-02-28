package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Hareesh Raj Ramanathan
 * 
 * This Program is to print the .
 *  
  */
public class Question3 {
	/**
	 *  @param args is the argument unused.
	 *  we execute produce method and consumer method
	 *  we are closing the thread in line 33.
	 * */
	public static void main(String[] args) {
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		FactoryOutlet fot=new FactoryOutlet();
		es.execute(()->{
			for(int i=0;i<5;i++)
			{
				fot.produce();
			}
		});
		es.execute(()->{
			for(int i=0;i<2;i++)
			{
				fot.consume();
			}
		});
		es.shutdown();
	}

}

class FactoryOutlet{
	int prodCount=0;
	/**
	 *  we execute produce method .
	 * */
	synchronized public void produce()
	{
		if( prodCount==1)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("Product Produced..");
		prodCount++;
		notify();
	}
	/**
	 *  we execute  consumer method.
	 * */
	synchronized public void consume()
	{
		if(prodCount==0)
		{
			try {
					wait();
				} catch (InterruptedException e) {
		
					e.printStackTrace();
			}
		}
		System.out.println("Product Consumed..");
		prodCount--;
		notify();
	}
}