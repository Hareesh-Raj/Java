package Exercise4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrototypePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			Prototype obj;
			obj=Prototype.createInstance();
		});
		es.execute(()->{
			Prototype obj;
			obj=Prototype.createInstance();
		});
		es.shutdown();
	}

}

class Prototype implements Cloneable{
	private static Prototype obj;
	
	private Prototype()
	{
		System.out.println("Hiiii");
	}
	public static Prototype createInstance()
	{
		if(obj==null)
		{
			synchronized(Prototype.class) {
				if(obj==null)
				obj=createNewInstance();				
			}
			return obj;
		}
		else
		{
			return obj.cloneInstance();
		}
	}
	private static Prototype createNewInstance()
	{
		return new Prototype();
	}
	private  Prototype cloneInstance()
	{
		try {
			return (Prototype)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}