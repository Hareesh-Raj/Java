package Exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadException obj=new ThreadException();
		ExecutorService es=Executors.newFixedThreadPool(3);
		es.execute(()->{
			synchronized(obj) {
				String str="hello";
				for(int i=0;i<str.length();i++)
				{
					try {
						obj.count(str.charAt(i));
					}
					catch(IllegalInputException e) {
					System.out.println(e);	
					}
					}
				obj.result();
			}
			
			});
		es.execute(()->{
			synchronized(obj)
			{
				ThreadException.countChar=0;
				int i;
				String str="abi4567%";
				for( i=0;i<str.length();i++)
				{
					try {
						obj.count(str.charAt(i));
					}
					catch(IllegalInputException e) {
					System.out.println(str.charAt(i)+""+e+"Second");	
					}
					}
				obj.result();
			}
			
			});
		es.execute(()->{
			synchronized(obj)
			{
				int i;
				ThreadException.countChar=0;
				String str="34dsfsg";
				for(i=0;i<str.length();i++)
				{
					try {
						obj.count(str.charAt(i));
					}
					catch(IllegalInputException e) {
						System.out.println(str.charAt(i)+""+e+"Third");	
					}
					}
				obj.result();
			}
			});
		es.shutdown();
		
}
}
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
class IllegalInputException extends Exception{
	String msg;
	public IllegalInputException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
}