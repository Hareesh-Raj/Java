package day2;

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Static obj=new Static();
		Static obj2=new Static();
		Static obj3=new Static();
		Static obj4=new Static();
		System.out.println(obj2.count());
	}

}
class Static{
	static int count=0;
	Static()
	{
		System.out.println("Objected Created....");
		count++;
	}
	int count()
	{
		return count;
	}
}
