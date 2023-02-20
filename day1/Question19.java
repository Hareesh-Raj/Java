package day1;

public class Question19 {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr=new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
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
	}

}
