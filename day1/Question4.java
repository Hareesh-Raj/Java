package day1;

public class Question4 {
	public static boolean isPrime(int num)
	{
		if(num<=1)
			return false;
		else if(num==2)
			return true;
		else if(num%2==0)
			return true;
		for(int i=3;i<=Math.sqrt(num);i+=2) {
			if(num%i==0)
				return false;
		}
			return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num =49;
		if(isPrime(num))
			System.out.println("Prime");
		else
			System.out.println("NotPrime");
		
	}

}
