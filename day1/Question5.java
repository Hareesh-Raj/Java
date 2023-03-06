package day1;

public class Question5 {
	public static int avg(int[] arr)
	{
		int sum=0;
		for(int i:arr)
		{
			sum+=i;
		}
		return sum/arr.length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[]{12,34,56,23,56,80};
		System.out.println(avg(arr));
	}

}
