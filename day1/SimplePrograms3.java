package day1;

public class SimplePrograms3 {
	public static void search(int[] arr,int ele)
	{
		int count=0;
		int flag=0;
		int pos=-1;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==ele)
			{
				if(pos==-1)
					pos=i;
				count++;
				flag=1;
			}
		}
		if(flag==0)
		System.out.println("NotFound");
		else
		System.out.println("Found at pos "+pos+", Times Occured "+count);
	}
	
	//prime numbers
	
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
				System.out.println(i);
			}
		}
	}
	
	// Armstrong Number
	
	public static boolean armstrong(int n)
	{
		double copy=n;
		double val=0;
		while(n!=0)
		{
			val+=Math.pow(n%10,3);
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
		//13.
		int[][] marks=new int[][] {{1,56,78,89},{2,78,89,45},{3,78,89,56}};
		for(int i=0;i<3;i++)
		{
			int total=0;
			for(int j=0;j<4;j++)
			{
				total+=marks[i][j];
			}
			System.out.println("Total is "+total);
		}
		
		// 14 pending
		
		//15.a
		primenumbers(100);
		//15.b
		if(armstrong(5))
		{
			System.out.println("Armstrong Number");
		}
		else if(perfect(34))
		{
			System.out.println("Perfect Number");
		}
		else if(palindrome(234))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("NormalNumber");
		}
		
		//16.
		int[] arr=new int[] {12,36,35,87,89,12};
		search(arr,12);

		
	}
	

}

