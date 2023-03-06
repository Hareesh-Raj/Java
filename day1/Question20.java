package day1;

public class Question20 {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr=new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		int[] max=new int[3];
		for(int i=0;i<3;i++)
		{
			max[i]=Max(arr[i]);
			System.out.println(max[i]);
		}
	}

}
