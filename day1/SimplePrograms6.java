package day1;

public class SimplePrograms6 {
	
	public static void main(String[] args) {
	//22.
		Modifiers obj=new Modifiers();
		System.out.println(obj.a);
//		System.out.println(obj.b);//private 
		System.out.println(obj.c);
		System.out.println(obj.d);
		
		//23.
		Protected obj2=new Protected();
		System.out.println("Before Change "+obj2.aa);
		obj2.aa=20;
		obj2.print();
		
		//24.
		Quadratic quad1=new Quadratic();
		Quadratic quad2=new Quadratic(2,3,4);
		
		System.out.println(quad1.calculate(5));
		
		System.out.println(quad2.calculate(7));
	}

}

//22.
class Modifiers{
	public int a;
	private int b;
	protected int c;
	 int d;
}

//23.
class Protected{
	protected int aa=10;
	void print()
	{
		System.out.println("After Change "+aa);
	}
}

//24.
class Quadratic{
	double a;
	double b;
	double c;
	public Quadratic()
	{
		a=1;
		b=1;
		c=1;
	}
	public Quadratic(double a,double b,double c)
	{
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public double getA()
	{
		return a;
	}
	public double getB()
	{
		return b;
	}
	public double getC()
	{
		return c;
	}
	public double calculate(double x)
	{
		return (a*(Math.pow(x, 2)))+(b*x)+c;
	}
}