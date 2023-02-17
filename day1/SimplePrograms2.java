package day1;

public class SimplePrograms2 {
	public static void sortAsc(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
					{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					}
			}
		}
		for(int i:arr)
			System.out.println(i+" ");
	}
	public static void sortDesc(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
					{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					}
			}
		}
		for(int i:arr)
			System.out.println(i+" ");
	}
	public static int find(int[] arr,int num)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==num)
				return i;
		}
		return -1;
	}
	public static void reverse(int[] arr)
	{
		int i=0;
		int temp;
		int len=arr.length;
		while(i<len/2)
		{
			temp=arr[i];
			arr[i]=arr[len-i-1];
			arr[len-i-1]=temp;
			i++;
		}
		for(int ii:arr)
			System.out.println(ii);
	}
	public static void main(String[] args) {

		int[] arr=new int[] {12,34,56,24,67,4};
		//6. pending
		
		//7.
		sortAsc(arr);
		//sortDesc(arr);
		
		//8.
		int pos=find(arr,4);
		if(pos==-1)
		{
			System.out.println("NotFound");
		}
		else
		{
			System.out.println("Found at "+pos);
		}
		
		//9.
		reverse(arr);
		
		//10.
		System.out.println("10");
		int[][] arr2D=new int[4][4];
		int val=1;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				arr2D[i][j]=val++;
			}
		}
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(arr2D[i][j]+" ");
			}
			System.out.println("");
		}
		
		//11.
		System.out.println("11");
		val=1;
		arr2D=new int[4][4];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<=i;j++)
			{
				arr2D[i][j]=val++;
			}
		}
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(arr2D[i][j]+" ");
			}
			System.out.println("");
		}
//		System.out.println("Enter the new ");

	}

}
