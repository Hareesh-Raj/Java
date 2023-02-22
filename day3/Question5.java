package day3;
import day2.InterfaceImpl;
public class Question5 implements InterfaceImpl {

	public static void main(String[] args) {
		Question5 obj=new Question5();
		obj.method1();
		obj.method2();
		obj.method3();
	}

	@Override
	public void method1() {
		System.out.println("Method1");
		
	}

	@Override
	public void method2() {
		System.out.println("Method2");
		
	}

	@Override
	public void method3() {
		System.out.println("Method3");
		
	}

}
