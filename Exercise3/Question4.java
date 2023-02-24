package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question4 {

	public static void main(String[] args) {
	ExecutorService es=Executors.newFixedThreadPool(3);
	DigitalClock dc=new DigitalClock(30,46,1);
	
	es.execute(()->{
		while(true) {
			dc.sec();
		}
		
	});
	es.execute(()->{
		while(true) {
			dc.min();
		}
	});
	es.execute(()->{
		while(true) {
			dc.hrs();
		}
	});
	es.shutdown();
	}
	
}

class DigitalClock{
	int sec;
	int min;
	int hrs;
	DigitalClock(int sec,int min,int hrs)
	{
		this.sec=sec;
		this.min=min;
		this.hrs=hrs;
	}
	synchronized public void sec()
	{
		int i;
		if(sec<60)
		{
			for(i=sec;i<60;i++)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(hrs+":"+min+":"+i);
			}
			sec=i;
			notifyAll();
		}
		else
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
		}
		
	}
	synchronized public void min()
	{
		if(min<59 && sec==60)
		{
			sec=0;
			min++;	
			notifyAll();
		}
		else
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	synchronized public void hrs()
	{
		if(min==59)
		{
			min=0;
			sec=0;
			if(hrs==23)
				hrs=0;
			else
				hrs++;
			notifyAll();
		}
		else
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}