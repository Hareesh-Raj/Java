package day2;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base obj=new Base();
		obj.run();
	}

}

class Base{
	int a;
	Base()
	{
		a=10;
	}
	int[] arr=new int[] {1,2,3};
	Derived d=new Derived();
	public void run()
	{
		System.out.println("Before Passing In pass by value "+a);
		d.cbv(a);
		System.out.println("After Passing In pass by value "+a);
		System.out.println("Before Passing In pass by value "+arr[0]+" "+a);
		d.cbr(arr,this);
		System.out.println("Before Passing In pass by reference "+arr[0]+" "+this.a);
	}
}
class Derived{
	
	public void cbv(int a)
	{
		a=15;
	}
	public void cbr(int[] a,Base b)
	{
		a[0]=12;
		b.a=15;
	}
}