package Exercise2;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sample1 s=new sample1();
		s.mth1();

	}

}

class sample1{
	public void mth1()
	{
		mth2();
		System.out.println("caller");
	}
	public void mth2()
	{
		try{
			throw new Exception();
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("catch-mth2");
		}
		finally {
			System.out.println("finally-mth2");
		}
	}
	
}