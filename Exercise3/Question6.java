package Exercise3;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Hareesh Raj Ramanathan
 * 
 * This Program is to print count of the character in the string" .
 *  
  */
public class Question6 {
	public static void removeDup(ThreadException obj,String str)
	{
		int i;
		for(i=0;i<str.length();i++) {
			
		try {
			obj.count(str.charAt(i));
		}
		catch(IllegalInputException e) {
		System.out.println(str.charAt(i)+""+e+"Second");	
		}
		}
	}
	public static void main(String[] args) {
		ThreadException obj=new ThreadException();
		ExecutorService es=Executors.newFixedThreadPool(3);
		Scanner sc=new Scanner(System.in);
		es.execute(()->{
			synchronized(obj) {
				System.out.println("Enter the string1 to evaluate..");
				String str=sc.next();
				removeDup(obj,str);
				obj.result();
			}
			});
		es.execute(()->{
			synchronized(obj)
			{
				ThreadException.countChar=0;
				
				System.out.println("Enter the string2 to evaluate..");
				String str=sc.next();
				removeDup(obj,str);
				obj.result();
			}
			});
		es.execute(()->{
			synchronized(obj)
			{
				ThreadException.countChar=0;
				System.out.println("Enter the string3 to evaluate..");
				String str=sc.next();
				removeDup(obj,str);
				obj.result();
			}
			});
		es.shutdown();
}
}
/**
 * @param ch is used to check the character is a alphabet or number
 * if it is not character throw a new exception  
 *  
  */
class ThreadException {
	static int countChar;
	public void count(char ch) throws IllegalInputException
	{
		if(!Character.isLetter(ch)) {
			throw new IllegalInputException("Not a character");
		}
		else
		{
			countChar++;
		}
	}
	public void result()
	{
		System.out.println("There are"+countChar+"Characters....");
	}
}
/**
 * This class is to create a new exception" .
 *  
  */
class IllegalInputException extends Exception{
	String msg;
	public IllegalInputException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}
}