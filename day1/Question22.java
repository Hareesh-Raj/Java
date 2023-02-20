package day1;

public class Question22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modifiers obj=new Modifiers();
		System.out.println(obj.a);
//		System.out.println(obj.b);//private 
		System.out.println(obj.c);
		System.out.println(obj.d);
	}

}
class Modifiers{
	public int a;
	private int b;
	protected int c;
	 int d;
}