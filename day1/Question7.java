package day1;

public class Question7 {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[] {12,34,56,24,67,4};
		sortAsc(arr);
		//sortDesc(arr);

	}

}
