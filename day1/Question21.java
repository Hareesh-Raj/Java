package day1;

public class Question21 {
	public static void print(int val)
	{
		switch(val)
		{
		case 1:
			{	
			System.out.println("30");
			break;
			}
		case 2:
		{
			System.out.println("31");
			break;
		}
		case 3:
		{
			System.out.println("28");
			break;
		}
		case 4:
		{
			System.out.println("29");
			break;
		}
		}
	}
	public static int isLeap(int year)
	{
		if(year%4==0)
		{
			if(year%100==0)
			{
				if(year%400==0)
					return 1;
				else
					return 0;
			}
			return 1;
		}
		else
			return 0;
	}
	public static void printDays(int year)
	{
		int val=1;
		switch(val)
		{
		case 1:
			System.out.println("1 31");
		case 2:
		{
			int leap=isLeap(year);
			switch(leap)
			{
			case 0:
			{
				System.out.println("2 28");
				break;
			}
			case 1:
			{
				System.out.println("2 29");
				break;
			}
			}
		}
		case 3:
			System.out.println("3 31");
		case 4:
			System.out.println("4 30");
		case 5:
			System.out.println("5 31");
		case 6:
			System.out.println("6 30");
		case 7:
			System.out.println("7 31");
		case 8:
			System.out.println("8 31");
		case 9:
			System.out.println("9 30");
		case 10:
			System.out.println("10 31");
		case 11:
			System.out.println("11 30");
		case 12:
			System.out.println("12 31");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=2004;
		printDays(year);
	}

}
