package day1;
import java.util.*;
public class SimplePrograms {
	
	public static boolean isPrime(int num)
	{
		if(num<=1)
			return false;
		else if(num==2)
			return true;
		else if(num%2==0)
			return true;
		for(int i=3;i<=Math.sqrt(num);i+=2) {
			if(num%i==0)
				return false;
		}
			return true;
		
	}
	public static int avg(int[] arr)
	{
		int sum=0;
		for(int i:arr)
		{
			sum+=i;
		}
		return sum/arr.length;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//1.
		System.out.println("Hello World");
		
		//2.
		System.out.println("Integer"+Primitive.intVar);
		System.out.println("Float"+Primitive.floatVar);
		System.out.println("Long"+Primitive.longVar);
		System.out.println("Double"+Primitive.doubleVar);
		System.out.println("byte"+Primitive.byteVar);
		System.out.println("char"+Primitive.charVar);
		System.out.println("short"+Primitive.shortVar);
		
		
		
		//3.
		
		int a='1';
		System.out.println("Hello"+a);
		
		float f=a;//implicit
		System.out.println("Hello2 "+f);
		
		double d=2.0;//explicit
		a=(int)d;
		System.out.println(a);
		
		//4.
		int num =49;
		if(isPrime(num))
			System.out.println("Prime");
		else
			System.out.println("NotPrime");
		
		// 5.
		int arr[]=new int[]{12,34,56,23,56,80};
		System.out.println(avg(arr));
		
	}

}
class Primitive{
	//2.
			static int intVar ;
			static boolean boolVar;
			static byte byteVar;
			static short shortVar ;
			static char charVar ;
			static long longVar ;
			static float floatVar ;
			static double doubleVar ;
}
