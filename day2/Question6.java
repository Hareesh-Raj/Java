package day2;

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticExample.hello();
		StaticExample obj=new StaticExample();
		StaticExample obj2=new StaticExample();
	}

}

class StaticExample{
	static {
		System.out.println("..STATIC CALLED..");
	}
	StaticExample()
	{
		System.out.println("Constructor called");
	}
	static public void hello()
	{
		System.out.println("Hello");
	}
}