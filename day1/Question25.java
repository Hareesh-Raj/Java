package day1;

public class Question25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Derived dObj=new Derived();
		dObj.useD();
	}

}
protected class base{
	String method() {
		return "Hello";
	}
}
class Derived{
	public void useD()
	{
		base z=new base();
		System.out.println("base says "+z.method());
	}
}