package Exercise2;

import java.io.IOException;

public class Question1 {

	public static void main(String[] args){		
//		try {
			HandleException.fun();
//		}
//		catch(Exception e){	}
	}

}

class HandleException{
	public static void fun() throws IOException 
	{
		throw new IOException();
	}
}