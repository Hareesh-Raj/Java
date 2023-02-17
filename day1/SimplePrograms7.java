package day1;

public class SimplePrograms7 {

	public static void main(String[] args) {
		// 
		Derived dObj=new Derived();
		dObj.useD();
	}

}

protected class base{
	String method() {
		return"Hello";
	}
}
class Derived{
	public void useD()
	{
		base z=new base();
		System.out.println("base says "+z.method());
	}
}