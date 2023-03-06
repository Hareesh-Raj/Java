package day1;

public class Question9 {
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
		// TODO Auto-generated method stub
		int[] arr=new int[] {12,34,56,24,67,4};
		reverse(arr);
	}

}
