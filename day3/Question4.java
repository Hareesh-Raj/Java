package day3;

public class Question4 {
	public static void func1(Interface1 obj1) {
		obj1.meth1interface1();
		obj1.meth2interface1();
	}
	public static void func2(Interface2 obj2)
	{
		obj2.meth1interface2();
		obj2.meth2interface2();
	}
	public static void func3(Interface3 obj3)
	{
		obj3.meth1interface3();
		obj3.meth2interface3();
	}
	public static void func4(NewInterface obj4)
	{
		obj4.newinterface();
	}
	public static void main(String[] args) {
		Tail t=new Tail();
		func1(t);
		func2(t);
		func3(t);
		func4(t);
		
	}

}
interface Interface1{
	abstract public void meth1interface1();
	abstract public void meth2interface1();
}
interface Interface2{
	abstract public void meth1interface2();
	abstract public void meth2interface2();
}
interface Interface3{
	abstract public void meth1interface3();
	abstract public void meth2interface3();
}
interface NewInterface extends Interface1,Interface2,Interface3{
	abstract public void newinterface();
}

class Head{
	
}
class Tail extends Head implements NewInterface{

	@Override
	public void meth1interface1() {
		System.out.println("Method 1 Interface1");
		
	}

	@Override
	public void meth2interface1() {
		System.out.println("Method 2 Interface1");
		
	}

	@Override
	public void meth1interface2() {
		System.out.println("Method 1 Interface2");
		
	}

	@Override
	public void meth2interface2() {
		System.out.println("Method 2 Interface2");
	}

	@Override
	public void meth2interface3() {
		System.out.println("Method 2 Interface3");
		
	}

	@Override
	public void newinterface() {
		System.out.println("Method  NewInterface");
		
	}

	@Override
	public void meth1interface3() {
		System.out.println("Method 1 Interface3");
		
	}
	
}

