package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Hareesh Raj Ramanathan
 * 
 * This Program is to print the String Hellooo" .
 *  
  */
public class Question5 extends Thread{
	public void run()
	{
		System.out.println("Helloo");
	}
	public static void main(String[] args) {
		Question5 obj=new Question5();
		Thread t=new Thread();
		obj.start();
		obj.start();
	}

}

