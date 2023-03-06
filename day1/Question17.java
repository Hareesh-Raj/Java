package day1;



public class Question17 {
	public void fun()
	{
		System.out.println("Hi");
	}
	public static void main(String[] args) {
//		Check obj=new Check(); // invoking the constructor without argument
		
//		fun(); // Accessing the non static content from static content
		 Check obj=new Check(4);
	}
}
class Const{
	 final int var=45;
	 Const()
	 {
//		 var=56; // to modify the const variable
	 }
}

class Check{
	Check(int i)
	{
		System.out.println("Hello from Check...");
	}
}
