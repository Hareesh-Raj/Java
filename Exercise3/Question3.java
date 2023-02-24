package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es=Executors.newFixedThreadPool(2);
		FactoryOutlet fot=new FactoryOutlet();
		es.execute(()->{
			for(int i=0;i<5;i++)
			{
				fot.produce();
			}
		});
		es.execute(()->{
			for(int i=0;i<5;i++)
			{
				fot.consume();
			}
		});
		es.shutdown();
	}

}

class FactoryOutlet{
	int prodCount=0;
	synchronized public void produce()
	{
		if( prodCount==1)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Product Produced..");
		prodCount++;
		notify();
	}
	synchronized public void consume()
	{
		if(prodCount==0)
		{
			try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		System.out.println("Product Consumed..");
		prodCount--;
		notify();
	}
}