package day2;

public class Question11 {

	public static void main(String[] args) {
		ClassC Cobj=new ClassC(3);

	}

}
class ClassA{
//	Aa()
//	{
//		System.out.println("hellooo");
//	}
	ClassA(int a)
	{
		System.out.println("Constructor A");
	}
}
class ClassB {
	ClassB(int a)
	{
		System.out.println("Constructor B");
	}
}
class ClassC extends ClassA{	
	ClassC(int a)
	{
		super(a);
		ClassB Bobj=new ClassB(5);
		System.out.println("Constructor C");
//		super(a);
	}
}