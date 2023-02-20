package day1;

public class Question16 {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[] {12,36,35,87,89,12};
		search(arr,12);
	}

}
