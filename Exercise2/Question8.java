package Exercise2;

import java.util.Scanner;

public class Question8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcAverage obj=new CalcAverage();
		System.out.println(obj.calc());
	}

}

class CalcAverage{
	int number;
	int avg;
	int count;
	Scanner sc=new Scanner(System.in);
	CalcAverage()
	{
		 avg=0;
		 count=10;
	}
	public int calc()
	{
		System.out.println("Enter the Numbers");
		for(int i=0;i<10;i++)
		{
			try {
				number=Integer.parseInt(sc.next());
			}
			catch(NumberFormatException e)
			{
				System.out.println("The input must be integer...");
				i--;
			}
			avg+=number;
		}
		return avg/count;
	}
}