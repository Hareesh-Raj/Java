package Exercise3;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			ThreadSynchronized.print("------[");
			ThreadSynchronized.print("Message2");
			ThreadSynchronized.print("]------");
			System.out.println();
		});
//		System.out.println();
		es.execute(()->{
			ThreadSynchronized.print("------[");
			ThreadSynchronized.print("Message3");
			ThreadSynchronized.print("]------");
			System.out.println();
		});
		es.shutdown();
	}

}

class ThreadSynchronized{
	 public static void print(String str)
	{
		System.out.print(str);
	}
}