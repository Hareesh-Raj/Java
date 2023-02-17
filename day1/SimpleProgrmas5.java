package day1;

import java.util.*;
public class SimpleProgrmas5 {
	public static int[] reverse(int[] arr)
	{
		int i=0;
		int n=arr.length;
		while(i<n/2)
		{
			int t=arr[i];
			arr[i]=arr[n-i-1];
			arr[n-i-1]=t;
			i++;
		}
		return arr;
	}
	public static int Max(int[] arr)
	{
		int max=arr[0];
		int n=arr.length;
		for(int i=1;i<n;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		return max;
	}
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
		int[][] arr=new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		Scanner sc=new Scanner(System.in);
		
		//19.
		for(int i=0;i<3;i++)
		{
			arr[i]=reverse(arr[i]);
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		//20.
		int[] max=new int[3];
		for(int i=0;i<3;i++)
		{
			max[i]=Max(arr[i]);
			System.out.println(max[i]);
		}
		
		//21.
		int year=sc.nextInt();
		printDays(year);
		

	}

}
