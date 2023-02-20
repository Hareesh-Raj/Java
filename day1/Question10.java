package day1;

public class Question10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
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

	}

}
