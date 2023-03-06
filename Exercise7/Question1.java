package Exercise7;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int count=0;
		while(sc.hasNext())
		{
			count++;
			sc.next().charAt(0);
		}
		System.out.println(count);
	}
// ctrl+z -- will pause the program and it will run it in background. we can bring the process to foreground by giving fg.
// ctrl+c  -- will terminate the program abruptedly.
}
