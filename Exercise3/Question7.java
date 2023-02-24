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
		es.shutdown();
	}

}
class PrintNumber{
	static int number=1;
	synchronized public  void number()
	{
		if(number%10==0)
		{
			print();
		}
		else
		{
			System.out.println(number);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		number++;
			
		}
		
	synchronized public  void print()
	{
		
			System.out.println("The Count reached.."+number);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
	}
}










//package Exercise3;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class Question7 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ExecutorService es=Executors.newFixedThreadPool(2);
//		PrintNumber pn=new PrintNumber();
//		es.execute(()->{
//			for(int i=0;i<100;i++)
//			{
//				pn.number();
//			}
//			
//		});
//		es.execute(()->{
//			for(int i=0;i<100;i++)
//			{
//				pn.status();
//			}
//		});
//		es.shutdown();
//	}
//
//}
//class PrintNumber{
//	static int number=1;
//	synchronized public  void number()
//	{
//		if(number%10==0) {
//			try {
//				
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		else
//		{
//			System.out.println(number);
////			try {
////				Thread.sleep(1000);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//			number++;
//			notify();
//		}
//		
//	}
//	synchronized public  void status()
//	{
//		if(number%10==0)
//		{
//			System.out.println("The Count reached.."+number);
//			number++;
//			notify();
//		}
//		else
//		{
//			try {
//				
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}


