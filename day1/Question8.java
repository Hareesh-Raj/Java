package day1;

public class Question8 {
	public static int find(int[] arr,int num)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==num)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[] {12,34,56,24,67,4};
		int pos=find(arr,4);
		if(pos==-1)
		{
			System.out.println("NotFound");
		}
		else
		{
			System.out.println("Found at "+pos);
		}
		
	}

}
