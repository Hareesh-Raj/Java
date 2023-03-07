package Exercise6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Logistics {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		KamatchiTransport travel=new KamatchiTransport();
		
		Lorry lorry=new Lorry("Ashok Leyland","TN 56 T 0007",90);
		
		Driver driver=new Driver(34,"Ram","DL202000");
		
		System.out.println("Enter the year..");
		int year=sc.nextInt();
		
		System.out.println("Enter the month..");
		int month=sc.nextInt();
		
		System.out.println("Enter the day..");
		int day=sc.nextInt();
		
		System.out.println("Enter the hours..");
		int hrs=sc.nextInt();
		
		System.out.println("Enter the minutes..");
		int min=sc.nextInt();
		
		Time time=new Time(year,month,day,hrs,min);
		LocalDateTime datetime = time.getTime();
		time.addLeaves();
		
		System.out.println("Enter the Kms to travel..");
		int kms=sc.nextInt();
		
		System.out.println("The Lorry Will reach at "+travel.delivery(kms, datetime, lorry, driver));
	}

}
abstract class Transport{
	abstract public String delivery(int distance,LocalDateTime time,Lorry lorry,Driver driver);
}
class KamatchiTransport extends Transport{
	@Override
	public String delivery(int distance,LocalDateTime  time,Lorry lorry,Driver driver)
	{
		
		int timetaken=(distance/lorry.max_speed)*60;
		
		/*
		 * In this while loop we are checking the whether the lorry is started at the leave days if it so then we need to add the days accordingly 
		 * because it will delay the time of delivery. 
		 * */
		
		while(Time.isLeave(time))
			{
				time=time.plusDays(1);
			}
		/*
		 * In this we are calculating the number of hours he can work on a the present day.
		 * */
			int remaining=Time.timeRemaining(time);
			/*
			 * If the work can be done in a same day then this condn will pass.
			 * */
			if(timetaken<=remaining)
			{
				time=time.plusMinutes(timetaken);
				return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))+"";
			}
			/*
			 * Since the constraints given the lorry driver can work only 8 hrs per day.
			 * so 8*60 = 480;
			 * we are running the loop until we find that a work can be less than or equal to 8 hrs.
			 * so that we can end it after calculating for the particular day. 
			 * */
			else
			{
				timetaken-=remaining;
				time=time.plusDays(1);
				while (timetaken >= 480) {
					if (!Time.isLeave(time)) {
						timetaken -= 480;
					}
					 time=time.plusDays(1);
				}
			}
			/*
			 * Here we are checking the that the end day is a leave or not.
			 * */
			while(Time.isLeave(time))
			{
				time=time.plusDays(1);
			}
			time=time.plusMinutes(timetaken);
		return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))+"";
	}
}
class Lorry{
	String brand;
	String lorryRegNumber;
	int max_speed;
	Lorry(String brand,String lorryRegNumber,int max_speed)
	{
		this.brand=brand;
		this.lorryRegNumber=lorryRegNumber;
		this.max_speed=max_speed;
	}
}
class Driver{
	String name;
	String licenseNumber;
	int age;
	Driver(int age,String name,String licenseNumber)
	{
		this.age=age;
		this.name=name;
		this.licenseNumber=licenseNumber;
	}
}
class Time{
	private LocalDateTime datetime ;
	static List<List<Integer>> leaves=new ArrayList<>(); 
	
	Time(int year,int month,int day,int hrs,int min){
		  datetime = LocalDateTime.of(year, month, day, hrs, min);  
	}
	public LocalDateTime getTime() {
		return datetime;
	}
	public static  boolean isLeave(LocalDateTime datetime)
	{
		
		if(isSunday(datetime) || isSecondSat(datetime) || isHoliday(datetime))
		{
			return true;
		}
		return false;
	}
	private static boolean isSunday(LocalDateTime datetime)
	{
		int dow=datetime.getDayOfWeek().getValue();
		if(dow==0)
		{
			return true;
		}
		return false;
	}
	private static boolean isHoliday(LocalDateTime datetime)
	{
		int day=datetime.getDayOfMonth();
		int month=datetime.getMonth().getValue();
		
		for(List<Integer> list:leaves)
		{
			if(list.get(0)==day && list.get(1)==month)
				return true;
		}
		return false;
	}
	private static boolean isSecondSat(LocalDateTime datetime)
	{
		int date=datetime.getDayOfMonth();
		int dow=datetime.getDayOfWeek().getValue();
		if(date>=7 && date<=14 && dow==7)
		{
			return true;
		}
		return false;
	}
	public static int timeRemaining(LocalDateTime datetime)
	{
		/*
		 * we are calculating the reamining minutes in a single day 
		 * since there is 1440 min in a single day we used it accordingly.*/
		int hrs=datetime.getHour();
		int min=datetime.getMinute();
		int calcmin=1440-hrs*60-min;
			if(calcmin>=480)
				return 480;
			else
				return calcmin;
	}
	public void addLeaves()
	{
		leaves.add(new ArrayList<Integer>(Arrays.asList(1,1)));
		leaves.add(new ArrayList<Integer>(Arrays.asList(26,1)));
		leaves.add(new ArrayList<Integer>(Arrays.asList(15,8)));
	}
}