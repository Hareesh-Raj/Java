package day3;

import day2.Day3ProtectedImpl;

public class Question6 {

	public static void main(String[] args) {
		Day3ProtectedImpl obj=new Day3ProtectedImpl();
		obj.method1();
	}

}
class ProtectedDemo extends Day3ProtectedImpl{
	public void doFunc()
	{
		Day3ProtectedImpl obj=new Day3ProtectedImpl();
		obj.method1();
	}
	
}

