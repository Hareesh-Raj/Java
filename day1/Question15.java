package day1;

public class Question15 {
	public static void primenumbers(int n)
	{
		int[] arr=new int[n+1];
		for(int i=0;i<n+1;i++)
			arr[i]=0;
			
		for(int i=2;i<n;i++)
		{
			if(arr[i]==0)
			{
				for(int j=i*i;j<n+1;j+=i)
				{
					arr[j]=1;
				}
			}
		}
		for(int i=2;i<n+1;i++)
		{
			if(arr[i]==0)
			{
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
	
	// Armstrong Number
	
	public static boolean armstrong(int n)
	{
		double copy=n;
		double val=0;
		String str=n+"";
		
		while(n!=0)
		{
			val+=Math.pow(n%10,str.length());
			n=n/10;
		}
		if(copy==val)
			return true;
		else
			return false;
	}
	//Perfect Number
	
	public static boolean perfect(int n)
	{
		if(n>=6) // least positive number is 6
		{
			int sum=1;
			for(int i=2;i<=n/2;i++)
			{
				if(n%i==0)
					sum+=i;
			}
			if(sum==n)
				return true;
		}
		
			return false;
		
	}
	
	// Palindrome
	
	public static boolean palindrome(int n)
	{
		int copy=n;
		int rev=0;
		int rem=0;
		while(n!=0)
		{
			rem=n%10;
			rev=rev*10+rem;
			n=n/10;
		}
		if(copy==rev)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primenumbers(100);
		//15.b
		int number=153;
		if(armstrong(number))
		{
			System.out.println("Armstrong Number");
		}
		else if(perfect(number))
		{
			System.out.println("Perfect Number");
		}
		else if(palindrome(number))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("NormalNumber");
		}
	}

}
