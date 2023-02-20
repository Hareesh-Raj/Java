package day1;

public class Question11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val=1;
		int[][] arr2D=new int[4][4];
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

	}

}
