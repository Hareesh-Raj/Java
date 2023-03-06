package day1;

public class Question24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quadratic obj=new Quadratic();
		System.out.println(obj.calculate(5));
		
		Quadratic obj2=new Quadratic(2,3,4);
		System.out.println(obj2.calculate(5));
	}

}
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