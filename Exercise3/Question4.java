package Exercise3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Hareesh Raj Ramanathan
 * 
 * This Program is to print the String "-----[Message1]------" without changing the order.
 *  
  */
public class Question4 {
	/**
	 *  @param args is the argument unused.
	 *  In this main method we create the digital clock.
	 *  we are closing the thread in line 44.
	 *  The Datetimeformatter is used to get the current time.
	 *  The Digital clock object is created and different methods are used to print the time
	 * */
	public static void main(String[] args) {
	ExecutorService es=Executors.newFixedThreadPool(3);
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	   String str=dtf.format(now); 
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
	/**
	 * Method sec() is used to print the seconds 
	 * 
	 * */
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
				
				e.printStackTrace();}
		}
		
	}
	/**
	 * Method min() is used to update the minutes 
	 * 
	 * */
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
	/**
	 * Method hrs() is used to print the hours 
	 * 
	 * */
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
				
				e.printStackTrace();
			}
		}
		
	}
}