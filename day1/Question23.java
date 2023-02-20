package day1;

public class Question23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Protected obj2=new Protected();
		System.out.println("Before Change "+obj2.aa);
		obj2.aa=20;
		obj2.print();
	}

}
class Protected{
	protected int aa=10;
	void print()
	{
		System.out.println("After Change "+aa);
	}
}