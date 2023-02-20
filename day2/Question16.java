package day2;

public class Question16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		X x1=new X();
		X x2=new Y();
		Y y1=new Y();
		
//		x2.do2();
//		y1.do1();
		((Y) x2).do2();//downcasting
	}

}
class X{
	void do1()
	{
		
	}
}
class Y extends X{
	void do2()
	{
		System.out.println("Helloooo...");
	}
}