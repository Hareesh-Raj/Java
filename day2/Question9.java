package day2;

public class Question9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B obj=new B();
		obj.check();
	}

}
class A{
	public int a=12;;
	private int b=23;;
	protected int c=45;
	int d=67;
	
}
class B extends A{
	void check()
	{
		System.out.println(a);
//		System.out.println(b);//private
		System.out.println(c);
		System.out.println(d);
	}
}