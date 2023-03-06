package day2;

public class Question8 {

	public static void main(String[] args) {
		Singleton obj1;
		obj1=Singleton.createInstance();
//		Singleton obj2=new Singleton();
		Singleton obj2;
		obj2=Singleton.createInstance();
		obj1.a=12;
		System.out.println(obj2.a);
		obj2.a=30;
		System.out.println(obj1.a);
	}

}


class Singleton{
	static Singleton obj;
	int a=0;
	private Singleton()
	{
		System.out.println("Const invoked");
	}
	static Singleton createInstance()
	{
		if(obj==null)
		{
			obj=new Singleton();
			return obj;
		}
		return obj;
	}
	
}