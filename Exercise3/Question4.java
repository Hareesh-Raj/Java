package Exercise3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question4 {

	public static void main(String[] args) {
	ExecutorService es=Executors.newFixedThreadPool(3);
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	   String str=dtf.format(now);  
//	   System.out.println(str.charAt(11));
	   int hrs=Integer.parseInt(str.substring(11,13));
	   int min=Integer.parseInt(str.substring(14,16));
	   int sec=Integer.parseInt(str.substring(17,19));
	DigitalClock dc=new DigitalClock(hrs,min,sec);
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
	DigitalClock(int hrs,int min,int sec)
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