package Exercise2;

public class Question2 {

	public static void main(String[] args) {
		sample s=new sample();
		s.mth1();
	}

}

class sample{
	public void mth1()
	{
		mth2();
		System.out.println("caller");
	}
	public void mth2()
	{
		try{
			throw new NullPointerException();
			return ;
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