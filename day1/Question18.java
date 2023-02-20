package day1;

public class Question18 {
	static int reverse(int n)
	{
		int rev=0;
		while(n!=0)
		{
			rev=rev*10+n%10;
			n/=10;
		}
		return rev;
	}
	static void print(int n)
	{
		switch(n)
		{
		case 0:
		{
			System.out.print("Zero");
			break;
		}
		case 1:
		{
			System.out.print("One");
			break;
		}
		case 2:
		{
			System.out.print("Two");
			break;
		}
		case 3:
		{
			System.out.print("Three");
			break;
		}
		case 4:
		{
			System.out.print("Four");
			break;
		}
		case 5:
		{
			System.out.print("Five");
			break;
		}
		case 6:
		{
			System.out.print("Six");
			break;
		}
		case 7:
		{
			System.out.print("Seven");
			break;
		}
		case 8:
		{
			System.out.print("Eight");
			break;
		}
		case 9:
		{
			System.out.print("Nine");
			break;
		}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=1256;
		number=reverse(number);
		while(number!=0)
		{
			print(number%10);
			number/=10;
		}
	}

}
