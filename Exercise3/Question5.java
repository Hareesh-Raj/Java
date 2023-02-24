package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question5 extends Thread{
	public void run()
	{
		System.out.println("Helloo");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ExecutorService es=Executors.newFixedThreadPool(1);
//		es.execute(()->{
//			System.out.println("Helloo");
//		});
//		es.shutdown();
//		es.execute(()->{});
		
		Question5 obj=new Question5();
		Thread t=new Thread();
		obj.start();
		obj.start();
//		t.start();
	}

}

