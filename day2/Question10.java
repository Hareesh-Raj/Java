package day2;

public class Question10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cc cObj=new Cc();

	}

}
class Aa{
	Aa()
	{
		System.out.println("Constructor A");
	}
}
class Bb {
	Bb()
	{
		System.out.println("Constructor B");
	}
}
class Cc extends Aa{
	Bb bObj=new Bb();
	
}