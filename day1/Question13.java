package day1;

public class Question13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] marks=new int[][] {{1,56,78,89},{2,78,89,45},{3,78,89,56}};
		for(int i=0;i<3;i++)
		{
			int total=0;
			for(int j=0;j<4;j++)
			{
				total+=marks[i][j];
			}
			System.out.println("Total is "+total);
		}
	}

}
