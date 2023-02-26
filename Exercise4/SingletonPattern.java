package Exercise4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//public class SingletonPattern {
//	 //early instance
//	private static SingletonPattern obj=new SingletonPattern();
//	private SingletonPattern()
//	{
//		System.out.println("hellooo");
//	}
//	public static SingletonPattern getInstance()
//	{
//		return obj;
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		
//	}
//
//}


public class SingletonPattern {
	 //lazy loading instance
	static Singleton obj;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			
			obj=Singleton.getInstance();
		});
		es.execute(()->{

			obj=Singleton.getInstance();
		});
		es.shutdown();
	}

}

class Singleton {
	static Singleton obj;
	private Singleton()
	{
		System.out.println("hellooo");
	}
	public static Singleton getInstance()
	{
		if(obj==null)
		{
			synchronized(Singleton.class)
			{
				if(obj==null) {
					obj=new Singleton();
				}
			}
			
		}
			return obj;
	}
	
	
}