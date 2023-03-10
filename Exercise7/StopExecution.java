package Exercise7;

import java.util.Scanner;

public class StopExecution {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int count=0;
		while(scanner.hasNext())
		{
			count++;
			scanner.next().charAt(0);
		}
		System.out.println(count);
	}
// ctrl+z -- will pause the program and it will run it in background. we can bring the process to foreground by giving fg.
// ctrl+c  -- will terminate the program abruptedly.
// ctrl+d will finish the execution of the program.
	// ctrl d means eof.
}
