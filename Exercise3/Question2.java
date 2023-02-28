package Exercise3;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Hareesh Raj Ramanathan
 * 
 * This Program is to print the String "-----[Message1]------" without changing the order.
 *  
  */
public class Question2 {
	/**
	 *  @param args is the argument unused.
	 *  In this main method we create three threads and we call the one static method to print the message.
	 *  we are closing the thread in line 48.
	 * */
	public static void main(String[] args) {
		/**
		 * We are creating a Fixedpool of size 3 and we are making the class Synchronization.
		 */
		ExecutorService es=Executors.newFixedThreadPool(3);
		ThreadSynchronized ts=new ThreadSynchronized();
		es.execute(()->{
			synchronized(ThreadSynchronized.class) {
			ThreadSynchronized.print("------[");
			ThreadSynchronized.print("Message1");
			ThreadSynchronized.print("]------");
			System.out.println();
			}
		});
		
		es.execute(()->{
			synchronized(ThreadSynchronized.class) {
				ThreadSynchronized.print("------[");
				ThreadSynchronized.print("Message2");
				ThreadSynchronized.print("]------");
				System.out.println();
				}
		});

		es.execute(()->{
			synchronized(ThreadSynchronized.class) {
				ThreadSynchronized.print("------[");
				ThreadSynchronized.print("Message3");
				ThreadSynchronized.print("]------");
				System.out.println();
				}
		});
		es.shutdown();
	}

}
/**
 * Created a class ThreadSynchronized as per the requirements and implemented the method to print the given a string.
 * */

class ThreadSynchronized{
	/**
	 *  @param str is the argument is used to print in the method.
	  */
	 public static void print(String str)
	{
		System.out.print(str);
	}
}